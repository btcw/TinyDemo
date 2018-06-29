package cn.make1.myhttptest.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import cn.make1.myhttptest.db.AuthorDao;
import cn.make1.myhttptest.db.BookDao;
import cn.make1.myhttptest.db.DaoSession;

/**
 * Comment: //作者的数据库实体
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
@SuppressWarnings("all")
@Entity
public class Author {

    @Id
    private Long id;

    private String name;

    private String address;

    /**
     * 这里ToMany对应的是book的id，即外键
     */
    @ToMany(referencedJoinProperty = "id")
    private List<Book> books;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1264723625)
    private transient AuthorDao myDao;

    @Generated(hash = 376400859)
    public Author(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Generated(hash = 64241762)
    public Author() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1047170309)
    public List<Book> getBooks() {
        if (books == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookDao targetDao = daoSession.getBookDao();
            List<Book> booksNew = targetDao._queryAuthor_Books(id);
            synchronized (this) {
                if (books == null) {
                    books = booksNew;
                }
            }
        }
        return books;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 353255226)
    public synchronized void resetBooks() {
        books = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 22439443)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAuthorDao() : null;
    }
}
