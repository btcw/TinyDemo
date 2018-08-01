package top.iwill.tinyapp.view.main

import android.Manifest
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
import top.iwill.tinyapp.utils.*
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
class MainActivity : BaseActivity()
        , SelectableBar.ItemSelectListener
        , AMap.OnMarkerClickListener {

    private lateinit var mAmap: AMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setScreenRotate(false)
        mainMapView.onCreate(savedInstanceState)
        mAmap = mainMapView.map
        mAmap.clearTools()
        val marker = mAmap.addCountMarker(this, LatLng(30.684615, 103.957773), STATUS_ON, 1024)
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
                startActivity(Intent(this@MainActivity, QrCodeScanActivity::class.java))
            }

            override fun refused(permission: String) {
                showToast(" 需要相机权限才能进行二维码扫描！", MyToast.OTHERS)
            }

        })
    }

    override fun onSelectedOn(isSelected: Boolean) {
    }

    override fun onSelectedOff(isSelected: Boolean) {
    }

    override fun onSelectedError(isSelected: Boolean) {
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        startActivity(Intent(this, PhotoListActivity::class.java))
        return true
    }
}
