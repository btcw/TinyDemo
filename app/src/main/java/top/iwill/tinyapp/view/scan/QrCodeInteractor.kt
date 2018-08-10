package top.iwill.tinyapp.view.scan

import cn.make1.cs.http.MakeOneObserver
import com.allen.library.RxHttpUtils
import com.allen.library.interceptor.Transformer
import com.orhanobut.hawk.Hawk
import top.iwill.tinyapp.db.HAWK_LOCAL_TOKEN
import top.iwill.tinyapp.http.ApiService
import top.iwill.tinyapp.http.entity.BaseResult

/**
 * Comment: //二维码页面耦合子
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/16
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class QrCodeInteractor {

    private val token = Hawk.get(HAWK_LOCAL_TOKEN, "token is null")

    fun bindDeviceByQrCode(deviceId: String, latitude: Double, longitude: Double, listener: BindDeviceListener) {

        RxHttpUtils.createApi(ApiService::class.java)
                .bindDevice(token, deviceId, latitude,longitude)
                .compose(Transformer.switchSchedulers<BaseResult<Any>>())
                .subscribe(object : MakeOneObserver<Any>() {
                    override fun onSuccess(data: Any?) {
                        listener.onBindSuccess()
                    }

                    override fun onError(code: Int, msg: String) {
                        listener.onError(code, msg)
                    }
                })
    }

    interface BindDeviceListener {

        fun onBindSuccess()

        fun onError(code: Int, msg: String)

    }


}
