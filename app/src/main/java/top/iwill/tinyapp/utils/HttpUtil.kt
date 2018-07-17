package top.iwill.tinyapp.utils

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * Comment: //网络请求相关工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/13
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
object HttpUtil {

    fun filesToMultipartBody(paramName: String, file: File): MultipartBody.Part {
        val requestBody = RequestBody.create(MediaType.parse("image/jpg"), file)
        return MultipartBody.Part.createFormData(paramName, file.name, requestBody)
    }


}