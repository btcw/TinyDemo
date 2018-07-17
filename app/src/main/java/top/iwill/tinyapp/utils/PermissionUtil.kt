package top.iwill.tinyapp.utils

import android.app.Activity
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.annotations.NonNull

/**
 * Comment: //权限申请工具类
 *
 * @author Jax.zhou in Make1
 * @date 2018/7/6
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
object PermissionUtil {

    fun requestPermission(activity: Activity, permission: String, @NonNull listener: PermissionListener) {

        val rxPermissions = RxPermissions(activity)

        rxPermissions.request(permission)
                .subscribe {
                    if (it)
                        listener.gratedPermission(permission)
                    else
                        listener.refused(permission)
                }


    }

    fun requestPermissions(activity: Activity, vararg permissions: String, @NonNull listener: PermissionsListener) {

        val rxPermissions = RxPermissions(activity)

        rxPermissions.requestEach(*permissions)
                .subscribe {
                    when {
                        it.granted -> listener.gratedPermission()
                        it.shouldShowRequestPermissionRationale -> listener.refused()
                        else -> listener.refusedAndNeverAsk()
                    }
                }

    }


    interface PermissionListener {

        fun gratedPermission(permission: String)

        fun refused(permission: String)
    }


    interface PermissionsListener {

        fun gratedPermission()

        fun refusedAndNeverAsk()

        fun refused()
    }

}
