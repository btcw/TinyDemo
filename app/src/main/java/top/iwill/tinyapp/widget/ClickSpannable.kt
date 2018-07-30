package top.iwill.tinyapp.widget

import android.graphics.Color
import android.support.v4.app.ActivityCompat
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView

/**
 * Comment: //可点击的spannable
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/5
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class ClickSpannable(private val onClickListener: View.OnClickListener) : ClickableSpan(), View.OnClickListener {


    override fun onClick(widget: View) {
        if (widget is TextView)
            widget.highlightColor = ActivityCompat.getColor(widget.context, android.R.color.transparent)
        onClickListener.onClick(widget)
    }

    override fun updateDrawState(ds: TextPaint) {
        ds.color = Color.parseColor("#FFFDB128")
    }
}