package top.iwill.tinyapp.http.entity

import com.google.gson.annotations.SerializedName

/**
 * Comment: //服务器返回的基本数据解析类
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/10
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class BaseResult<T> {

    /**
     * code : 200
     * description : 请求成功
     * timestamp : 1530770969
     * requestId : b15b5564-66d3-5bb3-95d5-862844d5
     * response : {"account":"15828420676","token":"665f644e43731ff9db3d341da5c827e1"}
     */

    var code: Int = 0
    var description: String? = null
    var timestamp: Long = 0
    var requestId: String? = null
    @SerializedName("response")
    var data: T? = null
}
