package cn.make1.cs.http

import com.allen.library.RxHttpUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import top.iwill.tinyapp.http.MakeOneApiException
import top.iwill.tinyapp.http.entity.BaseResult
import top.iwill.tinyapp.utils.MyLogger

/**
 * Comment: //观察者
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/7
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
abstract class MakeOneObserver<T> : Observer<BaseResult<T>> {


    override fun onSubscribe(disposable: Disposable) {
        RxHttpUtils.addDisposable(disposable)
    }

    override fun onNext(baseData: BaseResult<T>) {
        try {
            when (baseData.code) {
                200 -> onSuccess(baseData.data)
                else -> onError(MakeOneApiException(baseData.code, baseData.description ?: "描述为空"))
            }
        } catch (e: Exception) {
            MyLogger.e(e.stackTrace.toString())
        }
    }

    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
        if (e is MakeOneApiException)
            onError(e.code, e.des)
        else
            MyLogger.e("fatal Exception,系统错误,msg:" + e.message)
    }


    protected abstract fun onSuccess(data: T?)

    protected abstract fun onError(code: Int, msg: String)

}