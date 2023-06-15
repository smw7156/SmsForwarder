package `in`.shadman.smsforwarder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log

class SmsListener: BroadcastReceiver() {

    private val TAG = "SmsListener"

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG,"smw: broadCastReceiver onReceive for: ${intent?.action} ")
        val bnd = intent?.extras
        val objs = bnd?.getByteArray("pdus")
        val msg = SmsMessage.createFromPdu(objs)
        Log.i(TAG, "sms sender: ${msg.displayOriginatingAddress}")
        Log.i(TAG, "sms body: ${msg.displayMessageBody}")


//        when (intent?.action) {
//            Telephony.Sms.Intents.SMS_RECEIVED_ACTION -> {
//                Log.i(TAG, "smw: SMS_RECEIVED_ACTION")
//            }
//
//            Telephony.Sms.Intents.DATA_SMS_RECEIVED_ACTION -> {
//                Log.i(TAG, "smw: DATA_SMS_RECEIVED_ACTION")
//            }
//        }
    }
}