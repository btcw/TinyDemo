package top.iwill.tinyapp.view.photoList

import top.iwill.tinyapp.http.localentity.Device

/**
 * Comment: //设备图片列表界面更新
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
interface PhotoListView {

    /**
     * 首次进入获取到的图片列表
     * 主要是web接口不统一 这里也没有统一
     */
    fun onReceivePhotos(photos: ArrayList<String>)

    /**
     * 获得下一个设备
     */
    fun onReceiveNextDevice(device:Device)

    /**
     * 获得上一个设备
     */
    fun onReceiveLastDevice(device: Device)

    fun onError(msg: String)

}