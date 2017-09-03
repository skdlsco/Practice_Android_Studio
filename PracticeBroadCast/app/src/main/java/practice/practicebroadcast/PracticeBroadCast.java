package practice.practicebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by eka on 2017. 9. 3..
 */

public class PracticeBroadCast extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e(TAG, action);
        switch (action) {
            case "android.intent.action.ACTION_POWER_CONNECTED":
                Log.e(TAG, "POWER_CONNECTED");
                Toast.makeText(context, "충전기가 연결되었습니다.", Toast.LENGTH_SHORT).show();
                break;
            case "android.intent.action.ACTION_POWER_DISCONNECTED":
                Log.e(TAG, "POWER_DISCONNECTED");
                Toast.makeText(context, "충전기 연결이 해제되었습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
