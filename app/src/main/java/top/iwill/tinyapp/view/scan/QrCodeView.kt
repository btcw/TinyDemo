package cn.make1.cs.view.scan

/**
 * Comment: //二维码页面更新接口
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/16
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
interface QrCodeView{

    fun onBindSuccess(deviceId:String?)

    fun onError(msg:String)

}