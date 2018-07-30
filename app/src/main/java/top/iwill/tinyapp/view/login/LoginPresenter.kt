package cn.make1.cs.view.login

import cn.make1.cs.http.entity.LoginResult

/**
 * Comment: //主界面的presenter
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class LoginPresenter(private var mLoginView: LoginView?) {

    private val mLoginInteractor: LoginInteractor = LoginInteractor()

    fun login(account: String, password: String) {
        when {
            account.isEmpty() -> mLoginView?.onAccountEmpty()
            password.isEmpty() -> mLoginView?.onPasswordEmpty()
            else -> mLoginInteractor.login(account, password, object : LoginInteractor.LoginResultListener {
                override fun onLoginSuccess(result: LoginResult?) {
                    mLoginView?.onLoginSuccess()
                }

                override fun onLoginError(code: Int, msg: String) {
                    mLoginView?.onLoginError(code, msg)
                }

            })
        }
    }


    fun onDestroy() {
        mLoginView = null
    }


}