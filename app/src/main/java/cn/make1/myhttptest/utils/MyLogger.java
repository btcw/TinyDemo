package cn.make1.myhttptest.utils;

import com.orhanobut.logger.Logger;

/**
 * Comment: //日志输出类
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class MyLogger {

    private final static Boolean IS_PRINT_LOG = true;

    public static void o(Object object){
        if (IS_PRINT_LOG){
            Logger.d(object);
        }
    }

    public static void d(String tag,String msg){
        if (IS_PRINT_LOG){
            Logger.d(tag,msg);
        }
    }

    public static void e(String tag,String msg){
        if (IS_PRINT_LOG){
            Logger.e(tag,msg);
        }
    }

    public static void wtf(String tag,String msg){
        if (IS_PRINT_LOG){
            Logger.wtf(tag,msg);
        }
    }

    public static void json(String json){
        if (IS_PRINT_LOG){
            Logger.json(json);
        }
    }

}
