package study.study_0517;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class MainActivity extends AppCompatActivity {
    Gson gson= new Gson();
    String json;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        MyAdapter adapter = new MyAdapter();
        adapter.addData("a");
        adapter.addData("a");
        adapter.addData("a");
        adapter.addData("a");
        Log.e("asdf",""+gson.toJson(adapter));
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("adapter",gson.toJson(adapter));
        startActivity(intent);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }



}
