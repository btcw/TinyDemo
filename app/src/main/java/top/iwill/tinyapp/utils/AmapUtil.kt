package top.iwill.tinyapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.*
import top.iwill.tinyapp.R

/**
 * Comment: //高德地图工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/24
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */

/**
 * marker状态
 */
const val STATUS_ON = 1

const val STATUS_OFF = 0

const val STATUS_ERROR = 2


fun AMap.locateOnce() {
    val style = MyLocationStyle()
    style.showMyLocation(true)
    style.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE)
    style.strokeColor(0xFFFFFF)
    style.radiusFillColor(0xFFFFFF)
    myLocationStyle = style
    isMyLocationEnabled = true
}

fun AMap.clearTools() {
    uiSettings.isZoomControlsEnabled = false
}

/**
 * 添加带数字的marker
 * @param status marker状态
 * @param count marker的统计数量
 */
@SuppressLint("InflateParams")
fun AMap.addCountMarker(context: Context, location: LatLng, status: Int?, count: Int): Marker? {
    val view = LayoutInflater.from(context).inflate(R.layout.amap_marker_layout, null)
    val markerIcon = view.findViewById<ImageView>(R.id.marker_icon)
    val markerCount = view.findViewById<TextView>(R.id.marker_count_text)
    if (count == 0) {
        markerCount.visibility = View.GONE
    } else {
        markerCount.text = count.toString()
    }
    when (status) {
        STATUS_ON -> markerIcon.setImageResource(R.mipmap.ic_marker_on)
        STATUS_OFF -> markerIcon.setImageResource(R.mipmap.ic_marker_off)
        STATUS_ERROR -> markerIcon.setImageResource(R.mipmap.ic_marker_error)
        else -> markerIcon.setImageResource(R.mipmap.ic_marker_off)
    }
    val bitmapDescriptor = BitmapDescriptorFactory
            .fromBitmap(view.convertViewToBitmap())
    val option = MarkerOptions()
            .icon(bitmapDescriptor)
            .anchor(0.35f, 0.9f)
            .position(location)
    return addMarker(option)
}


fun AMap.addMarker(la: Double, lo: Double,bitmapDescriptor: BitmapDescriptor): Marker {
    val option = MarkerOptions()
            .anchor(0.5f, 0.5f)
            .icon(bitmapDescriptor)
            .position(LatLng(la, lo))
    return addMarker(option)
}

/**
 * 移动地图到目标视野
 * @param latLng 坐标
 */
fun AMap.moveTo(latLng: LatLng) {
    val cameraUpdate = CameraUpdateFactory.newLatLng(latLng)
    this.animateCamera(cameraUpdate)
}

/**
 * 移动地图到目标视野
 * @param la 纬度
 * @param lo 经度
 */
fun AMap.moveTo(la: Double, lo: Double) {
    val latLng = LatLng(la, lo)
    val cameraUpdate = CameraUpdateFactory.newLatLng(latLng)
    this.animateCamera(cameraUpdate)
}


