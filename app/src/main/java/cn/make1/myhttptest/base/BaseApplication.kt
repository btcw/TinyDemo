package cn.make1.myhttptest.base

import android.app.Application
import cn.make1.myhttptest.config.HttpConfig
import cn.make1.myhttptest.db.DbManager
import com.orhanobut.hawk.Hawk
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * Comment: //BaseApplication
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        //hawk初始化
        Hawk.init(this).build()
        //网络配置初始化
        HttpConfig.init(this)
        //日志输出工具初始化
        Logger.addLogAdapter(AndroidLogAdapter())
        //初始化数据库工具类
        DbManager.getInstance().init(this)
    }

    companion object {

        private var application: Application? = null

        /**
         * 获取App的Context
         */
        fun getApplication() = application!!
    }

}
