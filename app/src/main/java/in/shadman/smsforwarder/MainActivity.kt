package `in`.shadman.smsforwarder

import android.Manifest.permission.READ_SMS
import android.Manifest.permission.RECEIVE_SMS
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var smsReceiver: SmsListener
    private val intentFilter = IntentFilter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        intentFilter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
//        intentFilter.addAction(Telephony.Sms.Intents.DATA_SMS_RECEIVED_ACTION)
        Log.i(TAG, "smw: onCreate called")
        startCheck()
    }

    private fun startCheck() {
        val st = listOf<String>(RECEIVE_SMS,READ_SMS)
        if (PermissionUtils.isPermissionGranted(this, st)) {
            Log.i(TAG, "smw: READ_SMS permission is available")
//            smsReceiver = SmsListener()
//            registerReceiver(smsReceiver, IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION))
        } else {
            Log.e(TAG, "smw: READ_SMS permission is NOT available")
            PermissionUtils.requestMultiplePermission(this, st.toTypedArray(), 12)
        }
    }

    /**
     * @param permissions permission name (e.g. android.permission.READ_SMS)
     * @param grantResults 0 -> granted, -1 -> not granted
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.i(TAG, "smw: onRequestPermissionsResult: requestCode: $requestCode, ")
        for ((i, item) in permissions.withIndex()) {
            Log.i(TAG, "smw: permission is: ${permissions[i]}, grantResults is:${grantResults[i]}")
//            if (permissions[i] == READ_SMS && grantResults[i] == 0) {
//                smsReceiver = SmsListener()
//                registerReceiver(
//                    smsReceiver,
//                    intentFilter
//                )
//            }
        }
    }

    override fun onDestroy() {
//        unregisterReceiver(smsReceiver)
        super.onDestroy()
    }
}