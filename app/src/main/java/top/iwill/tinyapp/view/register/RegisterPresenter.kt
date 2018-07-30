package top.iwill.tinyapp.view.register

import cn.make1.cs.http.entity.RegisterResult
import cn.make1.cs.view.register.RegisterView
import top.iwill.tinyapp.utils.TimerUtil

/**
 * Comment: //注册界面主持
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/10
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class RegisterPresenter(var mRegisterView: RegisterView?) {


    private val mRegisterInteractor = RegisterInteractor()

    fun register(account: String, password: String) {
        if (account.isEmpty() || account.length != 11) {
            mRegisterView?.onAccountIllegal()
            return
        }
        if (password.isEmpty()) {
            mRegisterView?.onPasswordIllegal()
            return
        }
        mRegisterInteractor.register(account, password, object : RegisterInteractor.RegisterListener {
            override fun onRegisterSuccess(result: RegisterResult?) {
                mRegisterView?.onRegisterSuccess()
            }

            override fun onRegisterError(code: Int, msg: String) {
                mRegisterView?.onError(msg)
            }

        })
    }

    fun getMsgCode(account: String) {
        if (account.isEmpty() || account.length != 11) {
            mRegisterView?.onAccountIllegal()
            return
        }
        startCountDown()
        mRegisterInteractor.getMsgCode(account, object : RegisterInteractor.MsgCodeListener {
            override fun onMsgCodeSuccess() {
                mRegisterView?.onGetMsgSuccess()
            }

            override fun onMsgCodeError(code: Int, msg: String) {
                mRegisterView?.onError(msg)
            }
        })
    }

    fun verifyMsgCode(account: String, code: String) {
        if (account.isEmpty() || account.length != 11) {
            mRegisterView?.onAccountIllegal()
            return
        }
        if (code.isEmpty()) {
            mRegisterView?.onCodeEmpty()
            return
        }
        mRegisterInteractor.verifyMsgCode(account, code, object : RegisterInteractor.MsgVerifyListener {
            override fun onVerifySuccess() {
                mRegisterView?.onVerifyCodeSuccess()
            }

            override fun onVerifyError(code: Int, msg: String) {
                mRegisterView?.onError(msg)
            }
        })
    }


    /**
     * 开始倒计时
     */
    private fun startCountDown() {
        mRegisterView?.onStartCountDown()
        TimerUtil.startTimeDeCounter(object : TimerUtil.TimeDeCountListener {
            override fun onTimeUp() {
                mRegisterView?.onTimeUp()
            }

            override fun onTimeUpdate(millisecond: Long) {
                mRegisterView?.onCounting(millisecond / 1000)
            }
        }, 60000, 1000)
    }

    fun onDestroy() {
        mRegisterView = null
    }


}