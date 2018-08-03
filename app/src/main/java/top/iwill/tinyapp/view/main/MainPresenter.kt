package top.iwill.tinyapp.view.main

import com.orhanobut.hawk.Hawk
import top.iwill.tinyapp.base.BasePresenter
import top.iwill.tinyapp.db.HAWK_LOCAL_TOKEN
import top.iwill.tinyapp.http.entity.DevicePoint
import top.iwill.tinyapp.utils.STATUS_ERROR
import top.iwill.tinyapp.utils.STATUS_OFF
import top.iwill.tinyapp.utils.STATUS_ON

/**
 * Comment: //主界面主持
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class MainPresenter(var mMainView: MainView?): BasePresenter() {

    private val mMainInteractor = MainInteractor()

    private val mToken = Hawk.get(HAWK_LOCAL_TOKEN, "token is null")

    fun getDeviceList(status:Int) {
        mMainInteractor.getDevices(mToken,status, object : MainInteractor.DevicesListener {
            override fun onReceiveDevices(devices: List<DevicePoint>) {
                when (status){
                    STATUS_ON -> mMainView?.onReceiveONDevices(devices)
                    STATUS_OFF -> mMainView?.onReceiveOFFDevices(devices)
                    STATUS_ERROR -> mMainView?.onReceiveErrorDevices(devices)
                    else -> mMainView?.onReceiveONDevices(devices)
                }
            }

            override fun onError(code: Int, msg: String) {
                mMainView?.onError(msg)
            }
        })
    }

    override fun onDestroy() {
        mMainView = null
    }
}