package com.example.eka.study_0417_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private AQuery aq;
    private HashMap<String,String> param= new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText id = (EditText) findViewById(R.id.id1);
        final EditText password = (EditText) findViewById(R.id.password1);
        Button login = (Button) findViewById(R.id.login);
        Button sign_up= (Button) findViewById(R.id.sign_up1);

        aq= new AQuery(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                param.put("id",id.getText().toString());
                param.put("password",password.getText().toString());
                aq.ajax("http://soylatte.kr:3000/login",param, JSONObject.class,new AjaxCallback<JSONObject>(){
                    @Override
                    public void callback(String url, JSONObject object, AjaxStatus status) {
                        super.callback(url, object, status);
                        Log.e("asdf",url);
                        Log.e("asdf", String.valueOf(status.getCode()));
                        Log.e("asdf",object.toString());
                        try {
                            if ((boolean)object.get("success")){
                                Toast.makeText(MainActivity.this, "로그인성공!!!!"+ object.get("username"), Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(MainActivity.this, "로그인실패...   "+object.get("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
}
