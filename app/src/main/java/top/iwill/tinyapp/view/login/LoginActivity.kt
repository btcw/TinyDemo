package top.iwill.tinyapp.view.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import cn.make1.cs.view.login.LoginPresenter
import cn.make1.cs.view.login.LoginView
import kotlinx.android.synthetic.main.activity_login_layout.*
import top.iwill.tinyapp.R
import top.iwill.tinyapp.base.BaseActivity
import top.iwill.tinyapp.utils.MyLogger
import top.iwill.tinyapp.utils.SpannableStringUtil
import top.iwill.tinyapp.view.main.MainActivity
import top.iwill.tinyapp.view.register.RegisterActivity
import top.iwill.tinyapp.widget.MyToast


/**
 * Comment: //登录页面
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/5
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class LoginActivity : BaseActivity(), LoginView {

    private val mMainPresenter = LoginPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_layout)
        initView()
    }

    private fun initView() {
        SpannableStringUtil.setLinkedString(loginNoticeText
                , "还没有账号？马上注册", "马上注册", this)
    }


    override fun widgetClick(v: View) {
        when (v.id) {
            R.id.loginNoticeText -> gotoRegisterPage()
            R.id.submitBtn -> mMainPresenter.login(loginAccountEdit.text.toString(),loginPasswordEdit.text.toString())
            else -> MyLogger.d("widgetClick:+${v.id}")
        }
    }


    private fun gotoMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun gotoRegisterPage() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onLoginSuccess() {
        showToast("登录成功！", MyToast.SUCCESS)
        gotoMainActivity()
    }

    override fun onLoginError(code: Int, msg: String) {
        MyToast.show(msg, this, MyToast.ERROR)
    }

    override fun onAccountEmpty() {
        showToast("账号不能为空！",MyToast.ERROR)
    }

    override fun onPasswordEmpty() {
        showToast("密码不能为空！",MyToast.ERROR)
    }

    override fun onHasLogin() {
        gotoMainActivity()
    }

    override fun finish() {
        //如果直接finish会导致看到桌面再跳转，加个延时
        Handler().postDelayed({
            super.finish()
        }, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.onDestroy()
    }

}