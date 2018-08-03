package top.iwill.tinyapp.view.login

import cn.make1.cs.http.MakeOneObserver
import com.allen.library.RxHttpUtils
import com.allen.library.interceptor.Transformer
import top.iwill.tinyapp.http.ApiService
import top.iwill.tinyapp.http.entity.BaseResult
import top.iwill.tinyapp.http.entity.LoginResult


/**
 * Comment: //登录模型层
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/7
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class LoginInteractor {

    fun login(account: String, password: String, listener: LoginResultListener) {

        RxHttpUtils.createApi(ApiService::class.java)
                .login(account, password)
                .compose(Transformer.switchSchedulers<BaseResult<LoginResult>>())
                .subscribe(object : MakeOneObserver<LoginResult>() {
                    override fun onSuccess(data: LoginResult?) {
                        listener.onLoginSuccess(data)
                    }

                    override fun onError(code: Int, msg: String) {
                        listener.onLoginError(code, msg)
                    }
                })
    }


    interface LoginResultListener {

        fun onLoginSuccess(result: LoginResult?)

        fun onLoginError(code: Int, msg: String)
    }

}