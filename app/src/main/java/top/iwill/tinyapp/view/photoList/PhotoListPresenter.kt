package top.iwill.tinyapp.view.photoList

import top.iwill.tinyapp.base.BasePresenter

/**
 * Comment: //图片列表主持
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class PhotoListPresenter(var mPhotoListView:PhotoListView?) :BasePresenter(){

    private val mPhotoListInteractor = PhotoListInteractor()

    fun getPhotos(deviceId: String) {

        mPhotoListInteractor.getPhotoList(deviceId
                , object : PhotoListInteractor.PhotoListListener {
            override fun onReceivePhotos(photos: ArrayList<String>) {
                mPhotoListView?.onReceivePhotos(photos)
            }

            override fun onError(code: Int, msg: String) {
                mPhotoListView?.onError(msg)
            }

        })


    }

    override fun onDestroy() {
        mPhotoListView = null
    }



}