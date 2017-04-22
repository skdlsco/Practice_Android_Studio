package com.example.eka.study_0417_01;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by eka on 2017. 4. 17..
 */

public class SignUp extends Activity {
    private AQuery aq;
    private EditText id,password,username;
    private Button sign_up;
    HashMap<String,String> param= new HashMap<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

         id = (EditText) findViewById(R.id.id2);
         password = (EditText) findViewById(R.id.password2);
         username = (EditText) findViewById(R.id.username);
         sign_up = (Button) findViewById(R.id.sign_up2);

        aq = new AQuery(this);


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                param.put("id",id.getText().toString());
                param.put("password",password.getText().toString());
                param.put("username",username.getText().toString());

                aq.ajax("http://soylatte.kr:3000/register",param, JSONObject.class,new AjaxCallback<JSONObject>(){
                    @Override
                    public void callback(String url, JSONObject object, AjaxStatus status) {
                        super.callback(url, object, status);
                        Log.e("asdf",url.toString());
                        Log.e("asdf",String.valueOf(status.getCode()));
                        Log.e("asdf",object.toString());

                        try {
                            boolean success = (boolean) object.get("success");
                            if (success){
                                Toast.makeText(SignUp.this, "회원가입성공~~!!", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(SignUp.this, "회원가입실패", Toast.LENGTH_SHORT).show();
                            }
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
}
