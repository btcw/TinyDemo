package cn.make1.myhttptest.utils

import java.util.concurrent.*

/**
 * Comment: //线程池
 *
 * @author Jax.zhou in Make1
 * @date 2018/5/29
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
@Suppress("unused")
object ThreadPool {

    private var dbExecutor: ThreadPoolExecutor? = null

    private var netExecutor: ThreadPoolExecutor? = null

    private var commonExecutor: ThreadPoolExecutor? = null

    val dbThreadPool: ThreadPoolExecutor
        get() {
            dbExecutor = ThreadPoolExecutor(0, Int.MAX_VALUE, 60, TimeUnit.SECONDS
                    , SynchronousQueue(), ThreadFactory { r ->
                val t = Thread(r)
                t.name = "数据库线程：" + t.id
                t
            })
            return dbExecutor!!
        }

    val netThreadPool: ThreadPoolExecutor
        get() {
            netExecutor = ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS
                    , LinkedBlockingQueue(5), ThreadFactory { r ->
                val t = Thread(r)
                t.name = "网络线程：" + t.id
                t
            })
            return netExecutor!!
        }

    val commonThreadPool: ThreadPoolExecutor
        get() {
            commonExecutor = ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS
                    , LinkedBlockingQueue(), ThreadFactory { r ->
                val t = Thread(r)
                t.name = "通用线程：" + t.id
                t
            })
            return commonExecutor!!
        }


}
