package top.iwill.tinyapp.utils

import android.app.Activity
import android.graphics.Bitmap
import android.util.DisplayMetrics
import android.view.View


/**
 * Comment: //通用工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/23
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */

/**
 * 获取屏幕参数（宽高）
 */
fun getWindowMetrics(activity: Activity): DisplayMetrics {
    val manager = activity.windowManager
    val outMetrics = DisplayMetrics()
    manager.defaultDisplay.getMetrics(outMetrics)
    return outMetrics
}

/**
 * 获取控件高度
 */
fun View.getViewMetrics():Map<String,Int>{
    val w = View.MeasureSpec.makeMeasureSpec(0,
            View.MeasureSpec.UNSPECIFIED)
    val h = View.MeasureSpec.makeMeasureSpec(0,
            View.MeasureSpec.UNSPECIFIED)
    measure(w, h)
    return mapOf<String,Int>(Pair("height",measuredHeight),Pair("width",measuredWidth))
}

/**
 * 将view转换为bitmap
 */
fun View.convertViewToBitmap():Bitmap{

    measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            , View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))

    layout(0, 0, measuredWidth, measuredHeight)

    buildDrawingCache()

     return drawingCache

}


