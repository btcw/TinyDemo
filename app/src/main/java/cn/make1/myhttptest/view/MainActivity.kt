package cn.make1.myhttptest.view

import android.os.Bundle
import android.view.View

import cn.make1.myhttptest.R
import cn.make1.myhttptest.base.BaseActivity

/**
 * 首页
 * @author Dev.Zhou
 * @date 2018/6/28
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun widgetClick(v: View) {

    }
}
