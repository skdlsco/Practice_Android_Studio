package com.example.eka.study_0328;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private MyAdapter adapter;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager= (ViewPager) findViewById(R.id.pager);

        adapter = new MyAdapter(getLayoutInflater());
        PagerAdapter n_a = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(n_a);

//        Button prev= (Button) findViewById(R.id.prev);
//        Button next= (Button) findViewById(R.id.next);

//        prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                position= pager.getCurrentItem();
//                pager.setCurrentItem(position-1,true);
//            }
//        });
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                position= pager.getCurrentItem();
//                pager.setCurrentItem(position+1,true);
//            }
//        });
    }
}
