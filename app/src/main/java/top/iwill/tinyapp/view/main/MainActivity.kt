package top.iwill.tinyapp.view.main

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.amap.api.maps.AMap
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.Marker
import kotlinx.android.synthetic.main.activity_main.*
import top.iwill.tinyapp.R
import top.iwill.tinyapp.base.BaseActivity
import top.iwill.tinyapp.http.entity.DevicePoint
import top.iwill.tinyapp.utils.PermissionUtil
import top.iwill.tinyapp.utils.addCountMarker
import top.iwill.tinyapp.utils.clearTools
import top.iwill.tinyapp.utils.locateOnce
import top.iwill.tinyapp.view.photoList.PhotoListActivity
import top.iwill.tinyapp.view.scan.QrCodeScanActivity
import top.iwill.tinyapp.view.viewImg.ViewImgActivity
import top.iwill.tinyapp.widget.MyToast
import top.iwill.tinyapp.widget.SelectableBar


/**
 * 首页
 * @author Dev.Zhou
 * @date 2018/6/28
 */
class MainActivity : BaseActivity(), MainView
        , SelectableBar.ItemSelectListener
        , AMap.OnMarkerClickListener {


    private lateinit var mAmap: AMap

    private val mMainPresenter = MainPresenter(this)

    private val mONMarkerList = mutableListOf<Marker>()

    private val mOFFMarkerList = mutableListOf<Marker>()

    private val mERRORMarkList = mutableListOf<Marker>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setScreenRotate(false)
        mainMapView.onCreate(savedInstanceState)
        init()
    }


    private fun init() {
        mAmap = mainMapView.map
        mAmap.clearTools()
        mainBottomSelectableBar.setOnItemSelectListener(this)
        mAmap.setOnMarkerClickListener(this)
        locateMyLocation()
    }


    private fun locateMyLocation() {
        PermissionUtil.requestPermission(this
                , Manifest.permission.ACCESS_COARSE_LOCATION
                , object : PermissionUtil.PermissionListener {
            override fun gratedPermission(permission: String) {
                mAmap.locateOnce()
            }

            override fun refused(permission: String) {
                showToast("拥有定位权限可以查看当前手机位置！")
            }

        })

        PermissionUtil.requestPermission(this
                , Manifest.permission.WRITE_EXTERNAL_STORAGE
                , object : PermissionUtil.PermissionListener {
            override fun gratedPermission(permission: String) {

            }

            override fun refused(permission: String) {
                showToast("请允许读写权限！")
            }

        })

    }

    override fun onResume() {
        super.onResume()
        mainMapView.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        mainMapView.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        mainMapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainMapView.onDestroy()
    }


    override fun widgetClick(v: View) {
        when (v.id) {
            R.id.mainBindBtn -> requestLocation()
            R.id.mainCheckBtn -> startActivity(Intent(this, ViewImgActivity::class.java))
        }
    }

    /**
     * 请求定位
     */
    private fun requestLocation() {
        PermissionUtil.requestPermission(this
                , Manifest.permission.CAMERA
                , object : PermissionUtil.PermissionListener {
            override fun gratedPermission(permission: String) {
                startActivityForResult(Intent(this@MainActivity, QrCodeScanActivity::class.java),1)
            }

            override fun refused(permission: String) {
                showToast(" 需要相机权限才能进行二维码扫描！", MyToast.OTHERS)
            }

        })
    }


    /**
     * 把设备显示到地图上
     * @param mutableList 不同的设备列表
     */
    private fun addDeviceToMap(mutableList: MutableList<Marker>, devices: List<DevicePoint>) {
        mutableList.clear()
        for (index in devices.indices) {
            val device = devices[index]
            val marker = mAmap.addCountMarker(this, LatLng(device.latitude, device.longitude), device.runStatus, 0)
            marker?.`object` = device
            if (marker != null)
                mutableList.add(marker)
        }
    }

    private fun clearMarker(mutableList: MutableList<Marker>) {
        for (index in mutableList.indices) {
            mutableList[index].remove()
        }
        mutableList.clear()
    }

    override fun onSelectedOn(isSelected: Boolean) {
        if (isSelected)
            mMainPresenter.getDeviceList(DEVICE_LIST_STATUS_ON)
        else
            clearMarker(mONMarkerList)
    }

    override fun onSelectedOff(isSelected: Boolean) {
        if (isSelected)
            mMainPresenter.getDeviceList(DEVICE_LIST_STATUS_OFF)
        else
            clearMarker(mOFFMarkerList)
    }

    override fun onSelectedError(isSelected: Boolean) {
        if (isSelected)
            mMainPresenter.getDeviceList(DEVICE_LIST_STATUS_ERROR)
        else
            clearMarker(mERRORMarkList)
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        val device = marker!!.`object` as DevicePoint
        val intent = Intent(this, PhotoListActivity::class.java)
        intent.putExtra("deviceId", device.deviceId)
        intent.putExtra("latitude", device.latitude)
        intent.putExtra("longitude", device.longitude)
        startActivity(intent)
        return true
    }

    override fun onReceiveONDevices(devices: List<DevicePoint>) {
        addDeviceToMap(mONMarkerList, devices)
    }


    override fun onReceiveErrorDevices(devices: List<DevicePoint>) {
        addDeviceToMap(mERRORMarkList, devices)
    }

    override fun onReceiveOFFDevices(devices: List<DevicePoint>) {
        addDeviceToMap(mOFFMarkerList, devices)
    }

    override fun onError(des: String) {
        showToast(des, MyToast.ERROR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            if (mainBottomSelectableBar.isSelectedOn)
                mMainPresenter.getDeviceList(DEVICE_LIST_STATUS_ON)
            if (mainBottomSelectableBar.isSelectedOff)
                mMainPresenter.getDeviceList(DEVICE_LIST_STATUS_OFF)
            if (mainBottomSelectableBar.isSelectedError)
                mMainPresenter.getDeviceList(DEVICE_LIST_STATUS_ERROR)
        }
    }

}
