@file:Suppress("ConstantConditionIf")

package top.iwill.tinyapp.utils

import com.orhanobut.logger.Logger

/**
 * Comment: //日志输出类
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/28
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
@Suppress("unused")
object MyLogger {

    private const val IS_PRINT_LOG = true

    fun o(`object`: Any) {
        if (IS_PRINT_LOG) {
            Logger.d(`object`)
        }
    }

    fun d(msg: String) {
        if (IS_PRINT_LOG) {
            Logger.d(msg)
        }
    }

    fun e(msg: String) {
        if (IS_PRINT_LOG) {
            Logger.e(msg)
        }
    }

    fun wtf(msg: String) {
        if (IS_PRINT_LOG) {
            Logger.wtf(msg)
        }
    }

    fun json(json: String) {
        if (IS_PRINT_LOG) {
            Logger.json(json)
        }
    }

}
