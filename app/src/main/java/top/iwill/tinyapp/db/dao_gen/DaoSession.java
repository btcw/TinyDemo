package top.iwill.tinyapp.db.dao_gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import top.iwill.tinyapp.db.entity.Author;
import top.iwill.tinyapp.db.entity.Book;

import top.iwill.tinyapp.db.dao_gen.AuthorDao;
import top.iwill.tinyapp.db.dao_gen.BookDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig authorDaoConfig;
    private final DaoConfig bookDaoConfig;

    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        authorDaoConfig = daoConfigMap.get(AuthorDao.class).clone();
        authorDaoConfig.initIdentityScope(type);

        bookDaoConfig = daoConfigMap.get(BookDao.class).clone();
        bookDaoConfig.initIdentityScope(type);

        authorDao = new AuthorDao(authorDaoConfig, this);
        bookDao = new BookDao(bookDaoConfig, this);

        registerDao(Author.class, authorDao);
        registerDao(Book.class, bookDao);
    }
    
    public void clear() {
        authorDaoConfig.clearIdentityScope();
        bookDaoConfig.clearIdentityScope();
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

}
