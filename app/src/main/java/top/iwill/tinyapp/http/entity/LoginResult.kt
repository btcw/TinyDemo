package cn.make1.cs.http.entity

import com.google.gson.annotations.SerializedName

/**
 * Comment: //登录结果实体解析类
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/11
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class LoginResult {


    /**
     * uname : 15828420676
     * ulogo : /static/api/img_tmp/head.png
     * ugender : 1
     * token : 28c8edde3d61a0411511d3b1866f0636
     */

    @SerializedName("uname")
    var userName: String? = null

    @SerializedName("ulogo")
    var userHeadImg: String? = null

    @SerializedName("ugender")
    var userGender: Int = 1

    var token: String? = null
}
