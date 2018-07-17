package cn.make1.cs.http

/**
 * Comment: //自定义异常
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/7
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class MakeOneApiException(var code: Int) : RuntimeException() {

    lateinit var msg: String

    init {
        handleException(code)
    }

    private fun handleException(code: Int): MakeOneApiException {
        msg = when (code) {
            201 -> "问题描述"
            else -> "其他错误"
        }
        return this
    }

}