package top.iwill.tinyapp.view.scan

import top.iwill.tinyapp.base.BasePresenter

/**
 * Comment: //二维码页面的主持
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/16
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class QrCodePresenter(private var mQrCodeView: QrCodeView?):BasePresenter(){

    private val mQrCodeInteractor = QrCodeInteractor()

    fun bindDeviceByQrCode(deviceId:String){

//        mQrCodeInteractor.bindDeviceByQrCode(deviceId,object : QrCodeInteractor.BindDeviceListener{
//            override fun onBindSuccess(bindResult: BindResult?) {
//                mQrCodeView?.onBindSuccess(bindResult?.deviceId)
//            }
//
//            override fun onError(code: Int, msg: String) {
//                mQrCodeView?.onError(msg)
//            }
//        })
    }
    override fun onDestroy() {
        mQrCodeView = null
    }

}