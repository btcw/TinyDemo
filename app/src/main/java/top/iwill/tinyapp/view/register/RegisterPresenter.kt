package top.iwill.tinyapp.view.register

import top.iwill.tinyapp.base.BasePresenter
import top.iwill.tinyapp.http.entity.RegisterResult
import top.iwill.tinyapp.utils.TimerUtil

/**
 * Comment: //注册界面主持
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/10
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class RegisterPresenter(var mRegisterView: RegisterView?) : BasePresenter() {

    private val mRegisterInteractor = RegisterInteractor()

    fun register(account: String, password: String, code: String) {
        if (account.isEmpty() || account.length != 11) {
            mRegisterView?.onAccountIllegal()
            return
        }
        if (password.isEmpty()) {
            mRegisterView?.onPasswordIllegal()
            return
        }
        mRegisterInteractor.register(account, password, code, object : RegisterInteractor.RegisterListener {
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

    override fun onDestroy() {
        mRegisterView = null
    }


}