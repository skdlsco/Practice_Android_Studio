package practice.practicebroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.Toast

/**
 * Created by eka on 2017. 9. 3..
 */

class PracticeBroadCast : BroadcastReceiver() {
    private val TAG = "MyBroadcastReceiver"


    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        Log.e(TAG, action)
        when (action) {
            "android.intent.action.ACTION_POWER_CONNECTED" -> {
                Toast.makeText(context, "충전기가 연결되었습니다.", Toast.LENGTH_SHORT).show()
            }
            "android.intent.action.ACTION_POWER_DISCONNECTED" -> {
                Toast.makeText(context, "충전기 연결이 해제되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun peekService(myContext: Context?, service: Intent?): IBinder {
        return super.peekService(myContext, service)
    }
}
