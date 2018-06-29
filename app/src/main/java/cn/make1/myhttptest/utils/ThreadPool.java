package cn.make1.myhttptest.utils;

import android.support.annotation.NonNull;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Comment: //线程池
 *
 * @author Jax.zhou in Make1
 * @date 2018/5/29
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class ThreadPool {

    private static ThreadPoolExecutor dbExecutor;

    private static ThreadPoolExecutor netExecutor;

    private static ThreadPoolExecutor commonExecutor;

    public static ThreadPoolExecutor getDBThreadPool() {
        dbExecutor = new ThreadPoolExecutor(3, 6, 20, TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>(10), new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread t = new Thread(r);
                t.setName("数据库线程：" + t.getId());
                return t;
            }
        });
        return dbExecutor;
    }

    public static ThreadPoolExecutor getNetThreadPool() {
        netExecutor = new ThreadPoolExecutor(6, 12, 60, TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread t = new Thread(r);
                t.setName("网络线程：" + t.getId());
                return t;
            }
        });
        return netExecutor;
    }

    public static ThreadPoolExecutor getCommonThreadPool() {
        commonExecutor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread t = new Thread(r);
                t.setName("通用线程：" + t.getId());
                return t;
            }
        });
        return commonExecutor;
    }


}
