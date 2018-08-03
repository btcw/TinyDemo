package top.iwill.tinyapp.view.photoList

import cn.make1.cs.http.MakeOneObserver
import com.allen.library.RxHttpUtils
import com.allen.library.interceptor.Transformer
import com.orhanobut.hawk.Hawk
import top.iwill.tinyapp.db.HAWK_LOCAL_TOKEN
import top.iwill.tinyapp.http.ApiService
import top.iwill.tinyapp.http.entity.BaseResult
import top.iwill.tinyapp.http.entity.DevicePhotoResult

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
                        if (photos != null && photos.size > 0){
                            val photoUrls = ArrayList<String>()
                            for (index in photos.indices){
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

    interface PhotoListListener {

        fun onReceivePhotos(photos: ArrayList<String>)

        fun onError(code: Int, msg: String)
    }
}