package com.example.administrator.application_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.application_demo.R;

/**
 * Created by Administrator on 2017/5/17/017.
 */

public class HomeFragment extends Fragment {
    View view;
    RecyclerView mRecycler;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.home_fragment, container,false);
        }
        initView();
        return view;
    }

    private void initView() {
        mRecycler = (RecyclerView) view.findViewById(R.id.lately_recycler);
    }
}
