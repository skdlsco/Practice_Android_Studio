package practice.practicebroadcast

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log
import android.widget.Toast

/**
 * Created by eka on 2017. 9. 3..
 */

class MyService : Service() {
    var broadcastReceiver: PracticeBroadCast? = null

    override fun onCreate() {
        Toast.makeText(baseContext, "StartService", Toast.LENGTH_SHORT).show()
        startBroadcastReciver()
        Log.e("service", "onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("service", "onStartCommand")
        if (intent == null) {
            startBroadcastReciver()
        }
        return Service.START_NOT_STICKY
    }

    override fun onDestroy() {
        Log.e("service", "onDestroy")
        Toast.makeText(baseContext, "StopService", Toast.LENGTH_SHORT).show()
        super.onDestroy()
        unregisterReceiver(broadcastReceiver)
        Log.e("service", "unregister")
        stopSelf()
    }


    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    fun startBroadcastReciver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        broadcastReceiver = PracticeBroadCast()
        registerReceiver(broadcastReceiver, intentFilter)
    }
}

