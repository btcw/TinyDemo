package top.iwill.tinyapp.http

import io.reactivex.Observable
import retrofit2.http.*
import top.iwill.tinyapp.http.entity.*

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
    @Headers("Accept: application/json/")
    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("account") account: String
              , @Field("password") password: String): Observable<BaseResult<LoginResult>>

    /**
     * 注册接口
     */
    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("account") account: String
                 , @Field("password") password: String
                 , @Field("code") code: String): Observable<BaseResult<RegisterResult>>

    /**
     * 获取短信验证码
     * @param account 用户登录账号/使用手机号
     * @param codeType 验证码类型	注册=>'register',忘记密码=>'forget'
     */
    @FormUrlEncoded
    @POST("code/get_code")
    fun getMsgCode(@Field("account") account: String
                   , @Field("type") codeType: String): Observable<BaseResult<Any>>

    /**
     * 获取设备列表
     * @param token token
     * @param status 获取设备  1正常 2错误 0关闭
     */
    @FormUrlEncoded
    @POST("device/device_list")
    fun getDevices(@Header("token") token: String
                   , @Field("run_status") status: Int): Observable<BaseResult<DeviceListResult>>

    @FormUrlEncoded
    @POST("device/single_device")
    fun getDevicePhotos(@Header("token") token: String
                        , @Field("deviceId") deviceId: String) :Observable<BaseResult<DevicePhotoResult>>


    @GET("get接口api")
    fun test(@Query("id") id: Long): Observable<BaseResult<Any>>


}