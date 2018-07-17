package top.iwill.tinyapp.widget

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import top.iwill.tinyapp.R


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

        const val ERROR: Int = 0

        const val SUCCESS: Int = 1

        const val OTHERS: Int = 2

        private var mToast: Toast? = null

        fun show(msg: String, context: Context, type: Int) {
            if (mToast != null)
                mToast?.cancel()
            mToast = Toast(context.applicationContext)
            val view: View = View.inflate(context, R.layout.layout_toast, null)
            val toastText: TextView = view.findViewById(R.id.toastText)
            val cardView: CardView = view.findViewById(R.id.cardView)
//            mToast!!.setGravity(Gravity.START, 50, -getScreenHeight(context) / 4)
            mToast?.view = view
            toastText.text = msg
            mToast?.duration = Toast.LENGTH_SHORT

            when (type) {
                ERROR -> cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.red))
                SUCCESS -> cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.green))
                OTHERS -> cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.yellow))
                else -> cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.green))
            }
            mToast?.show()
        }

        fun show(msg: String, context: Context) {
            show(msg, context, -1)
        }

        fun getScreenHeight(context: Context): Int {
            val dm = DisplayMetrics()
            val manager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            manager.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }
    }
}