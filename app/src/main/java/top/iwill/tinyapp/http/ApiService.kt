package top.iwill.tinyapp.http

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import top.iwill.tinyapp.http.entity.BaseResult

/**
 * Comment: //请求服务接口
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
interface ApiService {


    @GET("get接口api")
    fun test(@Query("id") id: Long): Observable<BaseResult<Any>>


}