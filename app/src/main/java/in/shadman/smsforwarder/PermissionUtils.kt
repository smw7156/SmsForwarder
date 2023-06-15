package `in`.shadman.smsforwarder

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

/** Not using this utils. May be deleted in future*/

object PermissionUtils {

    fun isPermissionGranted(context: Context, permission: String): Boolean {
        return ActivityCompat.checkSelfPermission(context,permission) == PackageManager.PERMISSION_GRANTED
    }

    fun isPermissionGranted(context: Context, permissions: List<String>): Boolean {
        for (permission in permissions) {
            if (isPermissionGranted(context, permission)) {
               return false
            }
        }
        return true
    }

    fun isRationaleRequired(activity: Activity, permission: String): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity,permission)
    }

    fun isRationaleRequired(activity: Activity, permissions: List<String>): Boolean {
        for (permission in permissions){
            if (isRationaleRequired(activity,permission)) {
                return true
            }
        }
        return false
    }

    fun requestPermission(activity: Activity, permission: String, permissionCode: Int) {
        ActivityCompat.requestPermissions(activity,
            listOf<String>(permission).toTypedArray(),permissionCode)
    }

    fun requestMultiplePermission(activity: Activity, permission: Array<String>, permissionCode: Int) {
        ActivityCompat.requestPermissions(activity, permission,permissionCode)
    }

}