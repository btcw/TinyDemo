package cn.make1.myhttptest.costumview

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import cn.make1.myhttptest.R

/**
 * Comment: //土司
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/2
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class MyToast {

    companion object {

        private lateinit var mToast: Toast

        fun show(msg: String, context: Context) {
            mToast = Toast(context)
            val view: View = View.inflate(context, R.layout.layout_toast, null)
            mToast.view = view
            val toastText: TextView = view.findViewById(R.id.toastText)
            mToast.setGravity(Gravity.START, 50, -500)
            toastText.text = msg
            mToast.duration = Toast.LENGTH_SHORT
            mToast.show()
        }
    }
}