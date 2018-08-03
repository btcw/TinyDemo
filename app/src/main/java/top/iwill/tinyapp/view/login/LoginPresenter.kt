package top.iwill.tinyapp.view.login

import com.orhanobut.hawk.Hawk
import top.iwill.tinyapp.base.BasePresenter
import top.iwill.tinyapp.db.HAWK_LOCAL_TOKEN
import top.iwill.tinyapp.http.entity.LoginResult

/**
 * Comment: //主界面的presenter
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class LoginPresenter(private var mLoginView: LoginView?) : BasePresenter() {

    private val mLoginInteractor: LoginInteractor = LoginInteractor()

    fun login(account: String, password: String) {
        when {
            account.isEmpty() -> mLoginView?.onAccountEmpty()
            password.isEmpty() -> mLoginView?.onPasswordEmpty()
            else -> mLoginInteractor.login(account, password, object : LoginInteractor.LoginResultListener {
                override fun onLoginSuccess(result: LoginResult?) {
                    //本地存储token
                    Hawk.put(HAWK_LOCAL_TOKEN, result?.token)
                    mLoginView?.onLoginSuccess()
                }

                override fun onLoginError(code: Int, msg: String) {
                    mLoginView?.onLoginError(code, msg)
                }

            })
        }
    }

    override fun onDestroy() {
        mLoginView = null
    }

}