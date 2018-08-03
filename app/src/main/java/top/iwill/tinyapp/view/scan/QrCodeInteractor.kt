package top.iwill.tinyapp.view.scan

/**
 * Comment: //二维码页面耦合子
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/16
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class QrCodeInteractor {

//    private val mUserInteractor = UserDaoInteractor()
//
//    fun bindDeviceByQrCode(deviceId: String, listener: BindDeviceListener) {
//
//        val token = mUserInteractor.queryUser()?.token ?: ""
//
//        RxHttpUtils.createApi(ApiService::class.java)
//                .bindByQrCode(token, deviceId)
//                .compose(Transformer.switchSchedulers<BaseResult<BindResult>>())
//                .subscribe(object : MakeOneObserver<BindResult>() {
//                    override fun onSuccess(data: BindResult?) {
//                        listener.onBindSuccess(data)
//                    }
//
//                    override fun onError(code: Int, msg: String) {
//                        listener.onError(code, msg)
//                    }
//                })
//    }

    interface BindDeviceListener {

//        fun onBindSuccess(bindResult: BindResult?)

        fun onError(code: Int, msg: String)

    }


}
