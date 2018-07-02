package cn.make1.myhttptest.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Comment: //BaseActivity
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    /** 是否禁止旋转屏幕  */
    private var isAllowScreenRotate = true

    private var lastClick: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = if (!isAllowScreenRotate) {
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }

    fun setScreenRotate(isAllowScreenRotate: Boolean) {
        this.isAllowScreenRotate = isAllowScreenRotate
    }

    /** View点击  */
    abstract fun widgetClick(v: View)

    override fun onClick(v: View) {
        if (fastClick()) {
            widgetClick(v)
        }
    }

    private fun fastClick(): Boolean {
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false
        }
        lastClick = System.currentTimeMillis()
        return true
    }


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v!!.windowToken)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private fun isShouldHideKeyboard(v: View?, event: MotionEvent): Boolean {
        if (v != null && v is EditText) {
            val l = intArrayOf(0, 0)
            v.getLocationInWindow(l)
            val left = l[0]
            val top = l[1]
            val bottom = top + v.height
            val right = left + v.width
            // 点击EditText的事件，忽略它。
            return !(event.x > left && event.x < right
                    && event.y > top && event.y < bottom)
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     * @param token
     */
    private fun hideKeyboard(token: IBinder?) {
        if (token != null) {
            val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }


}
