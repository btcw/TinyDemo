package cn.make1.myhttptest.db;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Comment: //数据库操作类
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class DbManager {
    private BookDao mBookDao;
    private AuthorDao mAuthorDao;

    private DbManager() {

    }

    private static final class Holder {
        private static final DbManager INSTANCE = new DbManager();
    }

    public static DbManager getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context) {
        initDao(context);
    }

    private void initDao(Context context) {
        final DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, "test.db");
        final Database db = helper.getWritableDb();
        DaoSession mDaoSession = new DaoMaster(db).newSession();
        mBookDao = mDaoSession.getBookDao();
        mAuthorDao = mDaoSession.getAuthorDao();
    }

    public BookDao getBookDao() {
        return mBookDao;
    }

    public AuthorDao getAuthorDao() {
        return mAuthorDao;
    }
}
