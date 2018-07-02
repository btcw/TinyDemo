package cn.make1.myhttptest.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import cn.make1.myhttptest.R
import cn.make1.myhttptest.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 首页
 * @author Dev.Zhou
 * @date 2018/6/28
 */
class MainActivity : BaseActivity() {

    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setScreenRotate(false)
        editText.setOnClickListener(this)
    }

    override fun widgetClick(v: View) {
        showToast("点击${count++}次",Toast.LENGTH_SHORT)
    }
}
