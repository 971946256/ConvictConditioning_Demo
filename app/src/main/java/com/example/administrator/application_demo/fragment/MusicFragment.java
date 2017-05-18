package com.example.administrator.application_demo.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.application_demo.R;

/**
 * Created by Administrator on 2017/5/17/017.
 */

public class MusicFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.music_fragment, null);
        }
        TextView tv = (TextView) view.findViewById(R.id.music_frag);
        tv.setText("音乐");
        return view;
    }
}
