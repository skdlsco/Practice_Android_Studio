package study.study_0517;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main2Activity extends AppCompatActivity {
    Gson gson = new Gson();
    String json;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Intent intent = getIntent();
        json = intent.getStringExtra("adapter");
        Log.e("asdf","Main2");
        Log.e("asdf",""+json);
        MyAdapter adapter =  gson.fromJson(json, new TypeToken<MyAdapter>(){}.getType());
        adapter.addData("asdf");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }
}
