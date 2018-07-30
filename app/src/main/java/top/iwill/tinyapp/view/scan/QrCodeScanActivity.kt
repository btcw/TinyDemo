package top.iwill.tinyapp.view.scan

import android.os.Bundle
import android.view.View
import cn.make1.cs.view.scan.QrCodePresenter
import cn.make1.cs.view.scan.QrCodeView
import kotlinx.android.synthetic.main.activity_qr_scan_layout.*
import kotlinx.android.synthetic.main.custom_action_bar_layout.*
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView
import top.iwill.tinyapp.R
import top.iwill.tinyapp.base.BaseActivity
import top.iwill.tinyapp.utils.MyLogger
import top.iwill.tinyapp.widget.MyToast


/**
 * Comment: //二维码扫描页面
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class QrCodeScanActivity : BaseActivity(), ZBarScannerView.ResultHandler, QrCodeView {

    private val mQrCodePresenter = QrCodePresenter(this)

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_scan_layout)                // Set the scanner view as the content view
        scannerView.setAutoFocus(true)
        actionbarBack.visibility = View.VISIBLE
        actionbarTitle.text = "扫描二维码"
    }

    public override fun onResume() {
        super.onResume()
        scannerView.setResultHandler(this) // Register ourselves as a handler for scan results.
        scannerView.startCamera()          // Start camera on resume
    }

    public override fun onPause() {
        super.onPause()
        scannerView.stopCameraPreview()
        scannerView.stopCamera()           // Stop camera on pause
    }

    override fun onDestroy() {
        super.onDestroy()
        mQrCodePresenter.onDestroy()
    }


    override fun handleResult(result: Result?) {
        MyLogger.d("result:${result?.contents}")
        mQrCodePresenter.bindDeviceByQrCode(result?.contents?:"")

    }

    override fun onBindSuccess(deviceId: String?) {
//        Hawk.put(HAWK_DEVICE_ID,deviceId)
//        startActivity(Intent(this, DetailsActivity::class.java))
        finish()
    }

    override fun onError(msg: String) {
        MyToast.show(msg, this, MyToast.ERROR)
        scannerView.resumeCameraPreview(this)
    }


    override fun widgetClick(v: View) {
        when (v.id) {
            R.id.actionbarBack -> finish()
        }
    }

}