package top.iwill.tinyapp.utils

import android.text.TextUtils

/**
 * Comment: //text工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/13
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
@Suppress("unused")
object TextUtil {

    fun checkTextIsEmpty(text: String): Boolean {
        if (TextUtils.isEmpty(text)) {
            return true
        }
        if (text.contains(" ")) {
            val newStr = text.replace(" ".toRegex(), "")
            return TextUtils.isEmpty(newStr)
        }
        return false
    }
}
