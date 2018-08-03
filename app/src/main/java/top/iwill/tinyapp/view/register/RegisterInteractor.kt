package top.iwill.tinyapp.view.register


import cn.make1.cs.http.MakeOneObserver
import com.allen.library.RxHttpUtils
import com.allen.library.interceptor.Transformer
import top.iwill.tinyapp.http.ApiService
import top.iwill.tinyapp.http.entity.BaseResult
import top.iwill.tinyapp.http.entity.RegisterResult

/**
 * Comment: //注册模型层
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/10
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class RegisterInteractor {

    fun register(account: String, password: String, code: String, listener: RegisterListener) {
        RxHttpUtils.createApi(ApiService::class.java)
                .register(account, password, code)
                .compose(Transformer.switchSchedulers<BaseResult<RegisterResult>>())
                .subscribe(object : MakeOneObserver<RegisterResult>() {
                    override fun onSuccess(data: RegisterResult?) {
                        listener.onRegisterSuccess(data)
                    }

                    override fun onError(code: Int, msg: String) {
                        listener.onRegisterError(code, msg)
                    }
                })
    }

    /**
     * 发送短信获取验证码
     */
    fun getMsgCode(account: String, listener: MsgCodeListener) {
        RxHttpUtils.createApi(ApiService::class.java)
                .getMsgCode(account, "register")
                .compose(Transformer.switchSchedulers<BaseResult<Any>>())
                .subscribe(object : MakeOneObserver<Any>() {
                    override fun onSuccess(data: Any?) {
                        listener.onMsgCodeSuccess()
                    }

                    override fun onError(code: Int, msg: String) {
                        listener.onMsgCodeError(code, msg)
                    }
                })
    }


    interface RegisterListener {

        fun onRegisterSuccess(result: RegisterResult?)

        fun onRegisterError(code: Int, msg: String)

    }

    interface MsgCodeListener {

        fun onMsgCodeSuccess()

        fun onMsgCodeError(code: Int, msg: String)
    }

}