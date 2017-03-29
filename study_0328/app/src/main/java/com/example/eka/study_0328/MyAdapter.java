package com.example.eka.study_0328;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by eka on 2017. 3. 28..
 */

public class MyAdapter extends PagerAdapter {

    LayoutInflater inflater;

    public MyAdapter(LayoutInflater inflater){
        this.inflater=inflater;
    }

    @Override
    public int getCount() {

        return 100;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= inflater.inflate(R.layout.viewpaper,null);
        TextView text= (TextView) view.findViewById(R.id.text);
        text.setText("페이지"+(position+1));
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }
}
