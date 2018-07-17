package top.iwill.tinyapp.view

import android.os.Bundle
import android.view.View
import cn.make1.cs.http.MakeOneObserver
import com.allen.library.RxHttpUtils
import com.allen.library.interceptor.Transformer
import kotlinx.android.synthetic.main.activity_main.*
import top.iwill.tinyapp.R
import top.iwill.tinyapp.R.id.btn
import top.iwill.tinyapp.base.BaseActivity
import top.iwill.tinyapp.http.ApiService
import top.iwill.tinyapp.http.entity.BaseResult

/**
 * 首页
 * @author Dev.Zhou
 * @date 2018/6/28
 */
class MainActivity : BaseActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setScreenRotate(false)
        btn.setOnClickListener(this)
    }

    override fun widgetClick(v: View) {
        showToast("点击${count++}次")
        //请求实例
        RxHttpUtils.createApi(ApiService::class.java)
                .test(1)
                .compose(Transformer.switchSchedulers<BaseResult<Any>>())
                .subscribe(object : MakeOneObserver<Any>() {
                    override fun onSuccess(data: Any?) {

                    }

                    override fun onError(code: Int, msg: String) {

                    }
                })
    }
}
