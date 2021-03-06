package top.iwill.tinyapp.view.main

import top.iwill.tinyapp.http.entity.DevicePoint

/**
 * Comment: //主界面更新接口
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/26
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
interface MainView{

    fun onReceiveONDevices(devices:List<DevicePoint>)

    fun onReceiveErrorDevices(devices:List<DevicePoint>)

    fun onReceiveOFFDevices(devices:List<DevicePoint>)

    fun onError(des:String)

}