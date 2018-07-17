package top.iwill.tinyapp.db;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import top.iwill.tinyapp.db.dao_gen.AuthorDao;
import top.iwill.tinyapp.db.dao_gen.BookDao;
import top.iwill.tinyapp.db.dao_gen.DaoMaster;
import top.iwill.tinyapp.db.dao_gen.DaoSession;

/**
 * Comment: //数据库操作类
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class DaoManager {
    private BookDao mBookDao;
    private AuthorDao mAuthorDao;

    private DaoManager() {

    }

    private static final class Holder {
        private static final DaoManager INSTANCE = new DaoManager();
    }

    public static DaoManager getInstance() {
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
