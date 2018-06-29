package cn.make1.myhttptest.utils;

import android.text.TextUtils;

/**
 * Comment: //text工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/13
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class TextUtil {

    public static boolean checkTextIsEmpty(String text) {
        if (text.length() == 0){
            return true;
        }
        if (TextUtils.isEmpty(text)){
            return true;
        }
        if (text.contains(" ")){
            String newStr = text.replaceAll(" ","");
            return TextUtils.isEmpty(newStr);
        }
        return false;
    }
}
