package top.iwill.tinyapp.view.viewImg

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.custom_action_bar_layout.*
import top.iwill.tinyapp.R
import top.iwill.tinyapp.base.BaseActivity

/**
 * Comment: //大图浏览缩放页面
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/30
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class ViewImgActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_img_layout)
        initView()
    }

    private fun initView() {
        actionbarTitle.text = "查看图片"
    }


    override fun widgetClick(v: View) {
        when (v.id){
            R.id.actionbarBack -> finish()
        }
    }

}