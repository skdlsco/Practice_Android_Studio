package com.example.eka.study_0328;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment {
    int n;

    public BlankFragment(int n) {
        this.n = n;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.viewpaper, container, false);
        TextView text= (TextView) view.findViewById(R.id.text);
        text.setText(String.valueOf(n+1));
        return view;
    }

}
