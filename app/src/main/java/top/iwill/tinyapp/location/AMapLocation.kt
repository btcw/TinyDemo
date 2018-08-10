package top.iwill.tinyapp.location

import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener

/**
 * Comment: //高德定位
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/7
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
fun locateOnce(listener: AMapLocationListener) {
    val client = AMapConfig.getLocationClient()
    client.setLocationListener (listener)
    val option = AMapLocationClientOption()
    //获取一次定位结果：
    option.isOnceLocation = true
    //获取最近3s内精度最高的一次定位结果：
    //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。
    // 如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
    option.isOnceLocationLatest = true
    //给定位客户端对象设置定位参数
    client.setLocationOption(option)
    //启动定位
    client.startLocation()
}