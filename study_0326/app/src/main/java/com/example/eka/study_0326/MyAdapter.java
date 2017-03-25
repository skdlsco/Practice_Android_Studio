package com.example.eka.study_0326;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by eka on 2017. 3. 26..
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<ItemList> items;
    Context context;
    public MyAdapter(ArrayList<ItemList> items,Context context){
        this.items= items;
        this.context= context;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_view, null);
        TextView text_date= (TextView) view.findViewById(R.id.text_date);
        TextView text_memo= (TextView) view.findViewById(R.id.text_memo);

        ItemList item= items.get(position);

        text_date.setText(item.getText_date());
        text_memo.setText(item.getText_memo());
        return view;
    }


}
