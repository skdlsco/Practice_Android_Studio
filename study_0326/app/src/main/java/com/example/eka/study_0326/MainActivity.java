package com.example.eka.study_0326;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyAdapter adapter;
    private ArrayList<ItemList> items = new ArrayList<>();
    private Button btn;
    private ListView listView;
    private String strDate;
    private Gson gson;
    private SharedPreferences pref;
    private SharedPreferences.Editor pref_edit;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getPreferences(MODE_PRIVATE);
        pref_edit = pref.edit();

        gson = new Gson();

        String json = pref.getString("memo","null");

        if(json != "null") {
            items = gson.fromJson(json,  new TypeToken<List<ItemList>>(){}.getType());
        }

        listView= (ListView) findViewById(R.id.list);
        btn= (Button) findViewById(R.id.btn);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());

        strDate = dateFormat.format(date);

        adapter = new MyAdapter(items,this);
        listView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text= (EditText) findViewById(R.id.edit_text);

                ItemList item = new ItemList(String.valueOf(text.getText()),strDate);

                item.setText_date(strDate);
                items.add(item);

                String json = gson.toJson(items);

                pref_edit.putString("memo", json);

                pref_edit.apply();

                adapter.notifyDataSetChanged();
                text.setText("");
            }
        });

    }
}
