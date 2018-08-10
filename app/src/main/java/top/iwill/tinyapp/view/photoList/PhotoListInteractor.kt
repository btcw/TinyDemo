package top.iwill.tinyapp.view.photoList

import cn.make1.cs.http.MakeOneObserver
import com.allen.library.RxHttpUtils
import com.allen.library.interceptor.Transformer
import com.orhanobut.hawk.Hawk
import top.iwill.tinyapp.db.HAWK_LOCAL_TOKEN
import top.iwill.tinyapp.http.ApiService
import top.iwill.tinyapp.http.entity.BaseResult
import top.iwill.tinyapp.http.entity.DevicePhotoResult
import top.iwill.tinyapp.http.entity.NextDeviceResult
import top.iwill.tinyapp.http.localentity.Device

/**
 * Comment: //图片列表耦合子
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class PhotoListInteractor {

    private val token = Hawk.get(HAWK_LOCAL_TOKEN, "token is null")

    fun getPhotoList(deviceId: String, listener: PhotoListListener) {
        RxHttpUtils.createApi(ApiService::class.java)
                .getDevicePhotos(token, deviceId)
                .compose(Transformer.switchSchedulers<BaseResult<DevicePhotoResult>>())
                .subscribe(object : MakeOneObserver<DevicePhotoResult>() {
                    override fun onSuccess(data: DevicePhotoResult?) {
                        val photos = data?.photos
                        if (photos != null && photos.size > 0) {
                            val photoUrls = ArrayList<String>()
                            for (index in photos.indices) {
                                photoUrls.add(photos[index].picName)
                            }
                            listener.onReceivePhotos(photoUrls)
                        }
                    }

                    override fun onError(code: Int, msg: String) {
                        listener.onError(code, msg)
                    }
                })
    }

    fun getNextDevice(deviceId: String, order: Int, listener: NextDeviceListener) {
        RxHttpUtils.createApi(ApiService::class.java)
                .getNextDevice(token, deviceId, order)
                .compose(Transformer.switchSchedulers<BaseResult<NextDeviceResult>>())
                .subscribe(object : MakeOneObserver<NextDeviceResult>() {
                    override fun onSuccess(data: NextDeviceResult?) {
                        val photos = data?.photos
                        val photoUrls = arrayListOf<String>()
                        if (photos != null && photos.size > 0) {
                            for (index in photos.indices) {
                                photoUrls.add(photos[index].pic_name)
                            }
                        }
                        val device = Device(data?.deviceId, data?.location?.latitude, data?.location?.longitude)
                        device.photos = photoUrls
                        listener.onReceiveNextDevice(device)
                    }

                    override fun onError(code: Int, msg: String) {
                        listener.onError(code, msg)
                    }
                })

    }


    interface PhotoListListener {

        fun onReceivePhotos(photos: ArrayList<String>)

        fun onError(code: Int, msg: String)
    }

    interface NextDeviceListener {

        fun onReceiveNextDevice(device: Device)

        fun onError(code: Int, msg: String)
    }
}