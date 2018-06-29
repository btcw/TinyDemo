package cn.make1.myhttptest.utils;

import android.os.Handler;

/**
 * Comment: //计时器工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/5/26
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class TimerUtil {

    /**
     * 累计时间
     */
    private static long currentSecond;

    /**
     * 是否停止
     */
    private static boolean isStop = false;

    private static Handler mhandler ;

    /*****************计时器*******************/
    private static Runnable timeRunnable ;

    /**
     * 开始计时器
     * @param listener 时间监听
     * @param period 执行周期（最小单位时间） ms
     */
    public static void startTimeCounter(final TimeCountListener listener,final long period){
        //初始化
        isStop = false;
        currentSecond = 0;
        mhandler= new Handler();
        timeRunnable = new Runnable() {
            @Override
            public void run() {
                currentSecond = currentSecond + period;
                if (!isStop) {
                    //递归调用本runable对象，实现每隔一秒一次执行任务
                    mhandler.postDelayed(this, period);
                    if (listener != null){
                        listener.onTimeUpdate(currentSecond);
                    }
                }
            }
        };
        ThreadPool.getCommonThreadPool().execute(timeRunnable);
    }

    /**
     * 停止计时器
     */
    public static void stopTimerCount(){
        isStop = true;
    }

    public interface TimeCountListener{
    /**
     * 时间更新
     * @param millisecond 毫秒数
     */
    void onTimeUpdate(long millisecond);
}
}
