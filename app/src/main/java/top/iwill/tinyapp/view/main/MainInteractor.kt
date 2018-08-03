package top.iwill.tinyapp.view.main

import cn.make1.cs.http.MakeOneObserver
import com.allen.library.RxHttpUtils
import com.allen.library.interceptor.Transformer
import top.iwill.tinyapp.http.ApiService
import top.iwill.tinyapp.http.entity.BaseResult
import top.iwill.tinyapp.http.entity.DeviceListResult
import top.iwill.tinyapp.http.entity.DevicePoint

/**
 * Comment: //主界面耦合子
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class MainInteractor {

    fun getDevices(token: String, status: Int, listener: DevicesListener) {
        RxHttpUtils.createApi(ApiService::class.java)
                .getDevices(token, status)
                .compose(Transformer.switchSchedulers<BaseResult<DeviceListResult>>())
                .subscribe(object : MakeOneObserver<DeviceListResult>() {
                    override fun onSuccess(data: DeviceListResult?) {
                        listener.onReceiveDevices(data?.data ?: ArrayList())
                    }

                    override fun onError(code: Int, msg: String) {
                        listener.onError(code, msg)
                    }
                })
    }

    interface DevicesListener {

        fun onReceiveDevices(devices: List<DevicePoint>)

        fun onError(code: Int, msg: String)

    }

}