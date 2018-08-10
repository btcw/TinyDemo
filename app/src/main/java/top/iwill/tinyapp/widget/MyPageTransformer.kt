package top.iwill.tinyapp.widget

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPager
import android.view.View

/**
 * Comment: //todo
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class MyPageTransformer : ViewPager.PageTransformer {

    private val ROT_MAX = 20.0f
    private var mRot = 0.0f

    override fun transformPage(page: View, position: Float) {
        //页面不可见
        when {
            position < -1 -> ViewCompat.setRotation(page, 0f)
        //页面可见：页面的左边界已划出屏幕
            position < 0 -> {
                mRot = (ROT_MAX * position)
                ViewCompat.setPivotX(page, page.measuredWidth.toFloat())
                ViewCompat.setPivotY(page, page.measuredHeight.toFloat())
                ViewCompat.setRotation(page, mRot)
                //页面可见：页面的左边界已进入屏幕
            }
            position < 1 -> {
                mRot = (ROT_MAX * position)
                ViewCompat.setPivotX(page, 0f)
                ViewCompat.setPivotY(page, page.measuredHeight.toFloat())
                ViewCompat.setRotation(page, mRot)
            }
        //页面不可见
            else -> {
                ViewCompat.setRotation(page, 0f)
            }
        }
    }

}
