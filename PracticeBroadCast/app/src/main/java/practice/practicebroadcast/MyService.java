package practice.practicebroadcast;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by eka on 2017. 9. 3..
 */

public class MyService extends Service {
    BroadcastReceiver broadcastReceiver;

    @Override
    public void onCreate() {
        startBroadcastReciver();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            startBroadcastReciver();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    void startBroadcastReciver() {
        IntentFilter intentFilter = new IntentFilter();
        broadcastReceiver = new PracticeBroadCast();
        registerReceiver(broadcastReceiver, intentFilter);
    }
}
