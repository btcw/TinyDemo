package top.iwill.tinyapp.base

import android.app.Activity

/**
 * Comment: //活动页管理器
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/17
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
object ActivityCollector{

    private val activities = mutableListOf<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun  removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishAll(){
        for (activity in activities){
            activity.finish()
            activities.remove(activity)
        }
    }
}