package top.iwill.tinyapp.view.photoList

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.view.View
import com.amap.api.maps.AMap
import kotlinx.android.synthetic.main.activity_photo_list_layout.*
import top.iwill.tinyapp.R
import top.iwill.tinyapp.base.BaseActivity
import top.iwill.tinyapp.utils.clearTools
import top.iwill.tinyapp.utils.getWindowMetrics
import top.iwill.tinyapp.utils.locateOnce
import top.iwill.tinyapp.widget.MyToast

/**
 * Comment: //图片列表界面
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/23
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class PhotoListActivity : BaseActivity(), PhotoListView {

    private lateinit var mAmap: AMap

    private val mFragments = mutableListOf<Fragment>()

    private val mPhotoListPresenter = PhotoListPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list_layout)
        deviceMap.onCreate(savedInstanceState)
        initView()
    }

    private lateinit var mPagerAdapter: PhotoPagerAdapter

    private fun initView() {
        mAmap = deviceMap.map
        mAmap.setPointToCenter(getWindowMetrics(this).widthPixels / 2
                , getWindowMetrics(this).heightPixels / 4)
        mAmap.clearTools()
        mAmap.locateOnce()
        mPagerAdapter = PhotoPagerAdapter(mFragments, supportFragmentManager)
        photoViewPager.adapter = mPagerAdapter
        photoViewPager.currentItem = 0
        photoViewPager.offscreenPageLimit = 2
        val deviceId = intent.getStringExtra("deviceId")
        mPhotoListPresenter.getPhotos(deviceId)
    }

    override fun onResume() {
        super.onResume()
        deviceMap.onResume()
    }

    override fun onPause() {
        super.onPause()
        deviceMap.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        deviceMap.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        deviceMap.onSaveInstanceState(outState)
    }


    override fun widgetClick(v: View) {
        when (v.id) {
            R.id.actionbarBack -> finish()
        }
    }

    override fun onReceivePhotos(photos: ArrayList<String>) {
        val fragment = ListFragment()
        val b = Bundle()
        b.putStringArrayList("photos", photos)
        fragment.arguments = b
        mFragments.add(fragment)
        mPagerAdapter.notifyDataSetChanged()
    }

    override fun onError(msg: String) {
        showToast(msg, MyToast.ERROR)
    }


}
