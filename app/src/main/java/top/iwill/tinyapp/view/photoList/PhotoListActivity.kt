package top.iwill.tinyapp.view.photoList

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.amap.api.maps.AMap
import com.amap.api.maps.model.BitmapDescriptor
import com.amap.api.maps.model.BitmapDescriptorFactory
import kotlinx.android.synthetic.main.activity_photo_list_layout.*
import top.iwill.tinyapp.R
import top.iwill.tinyapp.base.BaseActivity
import top.iwill.tinyapp.http.localentity.Device
import top.iwill.tinyapp.utils.*
import top.iwill.tinyapp.widget.MyPageTransformer
import top.iwill.tinyapp.widget.MyToast

/**
 * Comment: //图片列表界面
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/23
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class PhotoListActivity : BaseActivity(), PhotoListView, ViewPager.OnPageChangeListener {


    private lateinit var mAmap: AMap

    private val mFragmentList = arrayListOf<Fragment>()

    private val mDeviceList = arrayListOf<Device>()

    private val mPhotoListPresenter = PhotoListPresenter(this)

    private lateinit var mBitmapDescriptor: BitmapDescriptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list_layout)
        deviceMap.onCreate(savedInstanceState)
        initView()
    }

    private lateinit var mPagerAdapter: PhotoPagerAdapter

    private fun initView() {
        mBitmapDescriptor = BitmapDescriptorFactory
                .fromResource(R.mipmap.ic_marker_on)
        mAmap = deviceMap.map
        mAmap.setPointToCenter(getWindowMetrics(this).widthPixels / 2
                , getWindowMetrics(this).heightPixels / 4)
        mAmap.clearTools()
        mAmap.locateOnce()
        mPagerAdapter = PhotoPagerAdapter(mFragmentList, supportFragmentManager)
        photoViewPager.adapter = mPagerAdapter
        photoViewPager.currentItem = 0
        photoViewPager.offscreenPageLimit = 2
        photoViewPager.setPageTransformer(true, MyPageTransformer())
        //Todo 添加Page监听
        photoViewPager.addOnPageChangeListener(this)
        getInfoByIntent()
        mPhotoListPresenter.getPhotos(mDeviceList[0].id)
    }

    private fun getInfoByIntent() {
        val deviceId = intent.getStringExtra("deviceId")
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)
        mDeviceList.add(Device(deviceId, latitude, longitude))
        mAmap.addMarker(latitude, longitude,mBitmapDescriptor)
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
        val currentDevice = mDeviceList[0]
        currentDevice.photos = photos
        addFragment(false, photos)
        mPhotoListPresenter.getLastDevice(currentDevice.id)
        mPhotoListPresenter.getNextDevice(currentDevice.id)
    }

    /**
     * 向viewpager添加fragment
     * @param isAhead 是否添加到前面
     * @param photos 图片列表
     */
    private fun addFragment(isAhead: Boolean, photos: ArrayList<String>) {
        val fragment = ListFragment()
        val b = Bundle()
        b.putStringArrayList("photos", photos)
        fragment.arguments = b
        if (isAhead) {
            mFragmentList.add(0, fragment)
            mPagerAdapter.notifyDataSetChanged()
            photoViewPager.setCurrentItem(1, false)
        } else {
            mFragmentList.add(fragment)
            mPagerAdapter.notifyDataSetChanged()
        }


    }


    override fun onReceiveNextDevice(device: Device) {
        mDeviceList.add(device)
        mAmap.addMarker(device.latitude, device.longitude,mBitmapDescriptor)
        addFragment(false, device.photos)
    }

    override fun onReceiveLastDevice(device: Device) {
        mDeviceList.add(0, device)
        mAmap.addMarker(device.latitude, device.longitude,mBitmapDescriptor)
        addFragment(true, device.photos)
    }


    override fun onError(msg: String) {
        showToast(msg, MyToast.ERROR)
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        val currentDevice = mDeviceList[position]
        mAmap.moveTo(currentDevice.latitude, currentDevice.longitude)
        //滑动到最后一条
        if (mDeviceList.size - 1 == position)
            mPhotoListPresenter.getNextDevice(currentDevice.id)
        if (position == 0)
            mPhotoListPresenter.getLastDevice(currentDevice.id)
    }

}
