package top.iwill.tinyapp.view.register

import android.os.Bundle
import android.view.View
import cn.make1.cs.view.register.RegisterView
import kotlinx.android.synthetic.main.activity_register_layout.*
import kotlinx.android.synthetic.main.custom_action_bar_layout.*
import top.iwill.tinyapp.R
import top.iwill.tinyapp.base.BaseActivity
import top.iwill.tinyapp.utils.MyLogger
import top.iwill.tinyapp.utils.SpannableStringUtil
import top.iwill.tinyapp.widget.MyToast

/**
 * Comment: //注册页面
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/5
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class RegisterActivity : BaseActivity(), RegisterView {

    private val mRegisterPresenter = RegisterPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_layout)
        initView()
    }

    private fun initView() {
        actionbarTitle.text = "注册"
        SpannableStringUtil.setLinkedString(registerNoticeText, "已有账号？直接登录", "直接登录", this)
    }


    override fun widgetClick(v: View) {
        when (v.id) {
            R.id.registerNoticeText -> gotoLoginPage()
            R.id.registerGetMessageBtn -> mRegisterPresenter.getMsgCode(phoneEditText.text.toString())
            R.id.registerBtn -> mRegisterPresenter.verifyMsgCode(phoneEditText.text.toString(), identifyCodeEditText.text.toString())
            else -> MyLogger.d("widgetClick:${v.id}")
        }
    }

    private fun gotoLoginPage() {
        finish()
    }

    override fun onRegisterSuccess() {
        showToast("注册成功！", MyToast.SUCCESS)
        gotoLoginPage()
    }

    override fun onGetMsgSuccess() {
        showToast("请注意接收短信！", MyToast.SUCCESS)
    }


    override fun onVerifyCodeSuccess() {
        mRegisterPresenter.register(phoneEditText.text.toString(), passwordEditText.text.toString())
    }

    override fun onAccountIllegal() {
        showToast("账号信息不正确！", MyToast.ERROR)
    }

    override fun onPasswordIllegal() {
        showToast("密码输入不正确！",  MyToast.ERROR)
    }

    override fun onCodeEmpty() {
        showToast("验证码不能为空！", MyToast.ERROR)
    }

    override fun onStartCountDown() {
        registerGetMessageBtn.isClickable = false
    }

    override fun onCounting(seconds: Long) {
        runOnUiThread {
            val des = "${seconds}s"
            registerGetMessageBtn.text = des
        }
    }

    override fun onTimeUp() {
        run {
            registerGetMessageBtn.isClickable = true
            registerGetMessageBtn.text = "获取验证码"
        }
    }

    override fun onError(msg: String) {
        showToast(msg, MyToast.ERROR)
    }

    override fun onDestroy() {
        super.onDestroy()
        mRegisterPresenter.onDestroy()
    }

}