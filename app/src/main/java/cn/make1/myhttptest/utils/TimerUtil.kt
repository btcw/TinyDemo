package cn.make1.myhttptest.utils

import android.os.Handler

/**
 * Comment: //计时器工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/5/26
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
@Suppress("unused")
object TimerUtil {

    /**
     * 累计时间
     */
    private var currentSecond: Long = 0

    /**
     * 是否停止
     */
    private var isStop = false

    private var mHandler: Handler? = null

    /*****************计时器 */
    private var timeRunnable: Runnable? = null

    /**
     * 开始计时器
     * @param listener 时间监听
     * @param period 执行周期（最小单位时间） ms
     */
    fun startTimeCounter(listener: TimeCountListener?, period: Long) {
        //初始化
        isStop = false
        currentSecond = 0
        mHandler = Handler()
        timeRunnable = object : Runnable {
            override fun run() {
                currentSecond += period
                if (!isStop) {
                    //递归调用本runnable对象，实现每隔一秒一次执行任务
                    mHandler!!.postDelayed(this, period)
                    listener?.onTimeUpdate(currentSecond)
                }
            }
        }
        ThreadPool.commonThreadPool.execute(timeRunnable)
    }

    /**
     * 停止计时器
     */
    fun stopTimerCount() {
        isStop = true
    }

    interface TimeCountListener {
        /**
         * 时间更新
         * @param millisecond 毫秒数
         */
        fun onTimeUpdate(millisecond: Long)
    }
}
