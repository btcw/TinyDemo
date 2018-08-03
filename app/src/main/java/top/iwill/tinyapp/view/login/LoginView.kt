package top.iwill.tinyapp.view.login

/**
 * Comment: //登录回调的页面更新接口
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
interface LoginView {

    /**
     * 登录成功
     */
    fun onLoginSuccess()

    /**
     * 登录失败
     * @param code 错误代码
     * @param msg 错误描述
     */
    fun onLoginError(code: Int, msg: String)

    /**
     * 账号为空
     */
    fun onAccountEmpty()

    /**
     * 密码为空
     */
    fun onPasswordEmpty()

    /**
     * 已经登录
     */
    fun onHasLogin()
}