package top.iwill.tinyapp.utils

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import top.iwill.tinyapp.widget.ClickSpannable

/**
 * Comment: //富文本工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/5
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
object SpannableStringUtil {

        /**
         * 设置textView可点击富文本显示
         * @param msg *整个*字符串
         * @param linkStr 可以点击的部分字符串
         */
        fun setLinkedString(textView:TextView,msg: String, linkStr: String,listener:View.OnClickListener) {
            val builder = SpannableStringBuilder(msg)
            val startIndex =(msg).indexOf(linkStr)
            val endIndex = startIndex + linkStr.length
            builder.setSpan(ClickSpannable(listener), startIndex, endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.movementMethod = LinkMovementMethod.getInstance()
            textView.text = builder
        }
}
