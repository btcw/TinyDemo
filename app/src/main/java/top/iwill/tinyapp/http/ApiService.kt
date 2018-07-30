package top.iwill.tinyapp.http

import cn.make1.cs.http.entity.LoginResult
import cn.make1.cs.http.entity.RegisterResult
import io.reactivex.Observable
import retrofit2.http.*
import top.iwill.tinyapp.http.entity.BaseResult
import top.iwill.tinyapp.http.entity.ReceiveMsgResult

/**
 * Comment: //请求服务接口
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
interface ApiService {


    /**
     * 登录接口
     */
    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("user/login_in")
    fun login(@Field("account") account: String
              , @Field("password") password: String): Observable<BaseResult<LoginResult>>

    /**
     * 注册接口
     */
    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("account") account: String
                 , @Field("password") password: String): Observable<BaseResult<RegisterResult>>

    /**
     * 获取短信验证码
     * @param account 用户登录账号/使用手机号
     * @param codeType 验证码类型	注册=>'register',忘记密码=>'forget'
     */
    @FormUrlEncoded
    @POST("code/verify")
    fun getMsgCode(@Field("account") account: String
                   , @Field("code_type") codeType: String): Observable<BaseResult<ReceiveMsgResult>>



    @GET("get接口api")
    fun test(@Query("id") id: Long): Observable<BaseResult<Any>>


}