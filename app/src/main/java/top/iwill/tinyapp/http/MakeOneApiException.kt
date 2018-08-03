package top.iwill.tinyapp.http

import org.greenrobot.eventbus.EventBus
import top.iwill.tinyapp.eventbus.InvalidTokenEvent

/**
 * Comment: //自定义异常
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/7
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
class MakeOneApiException(val code: Int, var des: String) : RuntimeException() {

    init {
        if (code == 202) EventBus.getDefault().post(InvalidTokenEvent())
    }
}