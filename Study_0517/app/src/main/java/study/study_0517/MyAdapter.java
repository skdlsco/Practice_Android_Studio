package study.study_0517;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by eka on 2017. 5. 17..
 */

class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    ArrayList<String> datas = new ArrayList<>();

    public void addData(String data){
        datas.add(data);
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text.setText(datas.get(position));
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

}