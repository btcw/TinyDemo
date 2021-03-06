package top.iwill.tinyapp.http

import android.app.Application
import com.allen.library.RxHttpUtils
import com.allen.library.config.OkHttpConfig

/**
 * Comment: //网络请求配置
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
object HttpConfig {

    private const val BASE_URL = "https://BaseUrl.xxx"

    fun init(application: Application) {

        //        Map<String, Object> headerMaps = new HashMap<>();

        val okHttpClient = OkHttpConfig.Builder()
                //全局的请求头信息
                //.setHeaders(headerMaps)
                //开启缓存策略(默认false)
                //1、在有网络的时候，先去读缓存，缓存时间到了，再去访问网络获取数据；
                //2、在没有网络的时候，去读缓存中的数据。
                .setCache(true)
                //全局持久话cookie,保存本地每次都会携带在header中（默认false）
                .setSaveCookie(true)
                //可以添加自己的拦截器(比如使用自己熟悉三方的缓存库等等)
                .setAddInterceptor(LoggingInterceptor())
                //全局ssl证书认证
                //1、信任所有证书,不安全有风险（默认信任所有证书）
                //.setSslSocketFactory()
                //2、使用预埋证书，校验服务端证书（自签名证书）
                //.setSslSocketFactory(cerInputStream)
                //3、使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
                .setSslSocketFactory(application.assets.open("server.cer")
                        , "214832908130915"
                        , application.assets.open("keystore.bks"))
                //全局超时配置
                .setReadTimeout(10)
                //全局超时配置
                .setWriteTimeout(10)
                //全局超时配置
                .setConnectTimeout(10)
                //全局是否打开请求log日志
                .setDebug(true)
                .build()

        RxHttpUtils
                .getInstance()
                .init(application)
                .config()
                //配置全局baseUrl
                .setBaseUrl(BASE_URL)
                //开启全局配置
                .setOkClient(okHttpClient)
    }
}
