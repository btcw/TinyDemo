package cn.make1.cs.view.register

/**
 * Comment: //注册页面接口
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/10
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
interface RegisterView{

    /**
     * 注册成功
     */
    fun onRegisterSuccess()

    /**
     * 获取验证码成功
     */
    fun onGetMsgSuccess()

    /**
     * 校验验证码成功
     */
    fun onVerifyCodeSuccess()

    /**
     * 请求失败
     */
    fun onError(msg:String)

    /**
     * 账号名不正确
     */
    fun onAccountIllegal()

    /**
     * 密码不正确
     */
    fun onPasswordIllegal()

    /**
     * 验证码为空
     */
    fun onCodeEmpty()

    /**
     * 开始倒计时 60s
     */
    fun onStartCountDown()

    /**
     * 倒计时中。。。
     */
    fun onCounting(seconds:Long)

    /**
     * 倒计时完成
     */
    fun onTimeUp()

}