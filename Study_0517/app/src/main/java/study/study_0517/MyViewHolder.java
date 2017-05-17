package study.study_0517;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by eka on 2017. 5. 17..
 */
class MyViewHolder extends RecyclerView.ViewHolder{
    TextView text;
    public MyViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.item_text);
    }

}