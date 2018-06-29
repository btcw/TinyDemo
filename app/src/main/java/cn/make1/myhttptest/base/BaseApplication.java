package cn.make1.myhttptest.base;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import cn.make1.myhttptest.config.HttpConfig;
import cn.make1.myhttptest.db.DbManager;

/**
 * Comment: //BaseApplication
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class BaseApplication extends Application {

    public static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        //网络配置初始化
        HttpConfig.init(this);
        //日志输出工具初始化
        Logger.addLogAdapter(new AndroidLogAdapter());
        //初始化数据库工具类
        DbManager.getInstance().init(this);
    }

}
