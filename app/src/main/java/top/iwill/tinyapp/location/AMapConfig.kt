package top.iwill.tinyapp.location

import android.annotation.SuppressLint
import android.app.Application
import com.amap.api.location.AMapLocationClient
import top.iwill.tinyapp.base.BaseApplication

/**
 * Comment: //高德定位初始化
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/7
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
object AMapConfig {

    @SuppressLint("StaticFieldLeak")
    private var mLocationClient: AMapLocationClient? = null

    fun init(application: Application) {
        //初始化定位
        mLocationClient = AMapLocationClient(application)
    }

    fun getLocationClient(): AMapLocationClient = mLocationClient
            ?: AMapLocationClient(BaseApplication.getAppInstance())
}