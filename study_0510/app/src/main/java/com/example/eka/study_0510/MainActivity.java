package com.example.eka.study_0510;

import android.appwidget.AppWidgetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;


public class MainActivity extends AppCompatActivity {
    BluetoothSPP bt;
    String receive;
    TextView text;
    Button button;
    Boolean islight=false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        text = (TextView) findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (islight){
                    bt.send("0",true);
                    text.setText("0");
                    islight=false;
                }else{
                    bt.send("1",true);
                    text.setText("1");
                    islight=true;
                }
            }
        });

        bt=new BluetoothSPP(this);

        if(!bt.isBluetoothAvailable())

        {
            Toast.makeText(getApplicationContext()
                    , "블루투스켜라이놈아"
                    , Toast.LENGTH_SHORT).show();
            finish();
        }

        bt.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener()

        {
            public void onDeviceConnected(String name, String address) {
                Toast.makeText(getApplicationContext()
                        , "연결됨ㅇㅇ", Toast.LENGTH_SHORT).show();
            }

            public void onDeviceDisconnected() {
                Toast.makeText(getApplicationContext()
                        , "연결끊김ㅇㅇ"
                        , Toast.LENGTH_SHORT).show();
            }

            public void onDeviceConnectionFailed() {
            }
        });

        bt.setAutoConnectionListener(new BluetoothSPP.AutoConnectionListener() {
            public void onNewConnection(String name, String address) {
            }

            public void onAutoConnectionStarted() {
            }
        });
        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            public void onDataReceived(byte[] data, String message) {
                receive = message;
                if (receive.equals("0")){}
                else if (receive.equals("1")){}
            }
        });

    }

    public void onDestroy() {
        super.onDestroy();
        bt.stopService();
    }

    public void onStart() {
        super.onStart();
        if (!bt.isBluetoothEnabled()) {
            bt.enable();
        } else {
            if (!bt.isServiceAvailable()) {
                bt.setupService();
                bt.startService(BluetoothState.DEVICE_OTHER);
                setup();
            }
        }
    }

    public void setup() {
        bt.autoConnect("test");
    }
}

