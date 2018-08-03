package top.iwill.tinyapp.view.photoList

/**
 * Comment: //设备图片列表界面更新
 *
 * @author Jax.zhou in Make1
 * @date 2018/8/3
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
interface PhotoListView {

    fun onReceivePhotos(photos: ArrayList<String>)

    fun onError(msg: String)

}