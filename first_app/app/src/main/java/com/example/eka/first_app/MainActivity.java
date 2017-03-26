package com.example.eka.first_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;

    boolean isN1Fill = false;
    boolean _n1=false;
    boolean _n2=false;
    int n1=0;
    int n2=0;
    int sum=0;
    int mode=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text= (TextView) findViewById(R.id.text);

        findViewById(R.id.numped2).setOnClickListener(this);
        findViewById(R.id.numped3).setOnClickListener(this);
        findViewById(R.id.numped4).setOnClickListener(this);
        findViewById(R.id.numped5).setOnClickListener(this);
        findViewById(R.id.numped6).setOnClickListener(this);
        findViewById(R.id.numped7).setOnClickListener(this);
        findViewById(R.id.numped8).setOnClickListener(this);
        findViewById(R.id.numped9).setOnClickListener(this);
        findViewById(R.id.numped0).setOnClickListener(this);
        findViewById(R.id.eq).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.multiply).setOnClickListener(this);
        findViewById(R.id.division).setOnClickListener(this);
        findViewById(R.id.dot).setOnClickListener(this);
        findViewById(R.id.del).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.numped0:
                text.setText(text.getText().toString() + "0");
                isN1Fill = false;
                break;
            case R.id.numped1:
                text.setText(text.getText().toString() + "1");
                isN1Fill = false;
                break;
            case R.id.numped2:
                text.setText(text.getText().toString() + "2");
                isN1Fill = false;
                break;
            case R.id.numped3:
                text.setText(text.getText().toString() + "3");
                isN1Fill = false;
                break;
            case R.id.numped4:
                text.setText(text.getText().toString() + "4");
                isN1Fill = false;
                break;
            case R.id.numped5:
                text.setText(text.getText().toString() + "5");
                isN1Fill = false;
                break;
            case R.id.numped6:
                text.setText(text.getText().toString() + "6");
                isN1Fill = false;
                break;
            case R.id.numped7:
                text.setText(text.getText().toString() + "7");
                isN1Fill = false;
                break;
            case R.id.numped8:
                text.setText(text.getText().toString() + "8");
                isN1Fill = false;
                break;
            case R.id.numped9:
                text.setText(text.getText().toString() + "9");
                isN1Fill = false;
                break;
            case R.id.del:
                String _text = text.getText().toString();
                if (_text.length() != 0) {
                    _text = _text.substring(0, _text.length() - 1);
                    text.setText(_text);
                }
                break;
            case R.id.plus:
                if (!isN1Fill) {
                    if (!_n1) {
                        n1 = Integer.valueOf(text.getText().toString());
                        text.setText("");
                        _n1 = true;
                    } else {
                        n2 = Integer.valueOf(text.getText().toString());
                        text.setText("");
                        cal();
                    }
                    isN1Fill = true;
                    mode = 1;
                }
                break;
            case R.id.minus:
                if (!isN1Fill) {
                    if (!_n1) {
                        n1 = Integer.valueOf(text.getText().toString());
                        text.setText("");
                        _n1 = true;
                    } else {
                        n2 = Integer.valueOf(text.getText().toString());
                        text.setText("");
                        cal();
                    }
                    isN1Fill = true;
                    mode = 2;
                }
                break;
            case R.id.multiply:
                if (!isN1Fill) {
                    if (!_n1) {
                        n1 = Integer.valueOf(text.getText().toString());
                        text.setText("");
                        _n1 = true;
                    } else {
                        n2 = Integer.valueOf(text.getText().toString());
                        text.setText("");
                        cal();
                    }
                    isN1Fill = true;
                    mode = 3;
                }
                break;
            case R.id.division:
                if (!isN1Fill) {
                    if (!_n1) {
                        n1 = Integer.valueOf(text.getText().toString());
                        text.setText("");
                        _n1 = true;
                    } else {
                        n2 = Integer.valueOf(text.getText().toString());
                        text.setText("");
                        cal();
                    }
                    isN1Fill = true;
                    mode = 4;
                }
                break;
            case R.id.eq:
                if (!isN1Fill) {
                    if (!_n2) {
                        n2 = Integer.valueOf(text.getText().toString());
                        cal();
                        text.setText(String.valueOf(sum));
                    } else text.setText(String.valueOf(sum));
                    mode = 0;
                    _n2 = false;
                    isN1Fill = false;
                    break;
                }
        }
    }
    public void cal(){
        switch (mode){
            case 1:
                sum=n1+n2;
                n1=sum;
                break;
            case 2:
                sum=n1-n2;
                n1=sum;
                break;
            case 3:
                sum=n1*n2;
                n1=sum;
                break;
            case 4:
                sum=n1/n2;
                n1=sum;
                break;
        }
    }
}

