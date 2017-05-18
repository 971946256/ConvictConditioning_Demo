package com.example.administrator.application_demo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.application_demo.R;
import com.example.administrator.application_demo.adapter.MyPagerAdapter;
import com.example.administrator.application_demo.fragment.HomeFragment;
import com.example.administrator.application_demo.fragment.MusicFragment;
import com.example.administrator.application_demo.fragment.TeachFragment;
import com.example.administrator.application_demo.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/17/017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Context mContext;
    View contextView;
    MyPagerAdapter adapter;
    ViewPager viewPager;
    TextView tvTop;
    LinearLayout homeLayout;
    LinearLayout teachLayout;
    LinearLayout musicLayout;
    LinearLayout userLayout;
    List<Fragment> mList = new ArrayList<>();
    String[] titleName = new String[]{"首页", "教程", "音乐","我的"};
    FragmentManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = MainActivity.this;
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        contextView = getLayoutInflater().inflate(R.layout.main_activity, null);
        setContentView(contextView);
        initData();
        initView();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    private void initView() {
        viewPager = (ViewPager) contextView.findViewById(R.id.view_pager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                boolean[] state = new boolean[titleName.length];
                state[position] = true;
                tvTop.setText(titleName[position]);
                updataViewPager(state[0], state[1], state[2],state[3]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        tvTop = (TextView) contextView.findViewById(R.id.top_title);
        homeLayout = (LinearLayout) findViewById(R.id.home_layout);
        homeLayout.setOnClickListener(this);
        homeLayout.setSelected(true);
        musicLayout = (LinearLayout) findViewById(R.id.music_layout);
        musicLayout.setOnClickListener(this);
        teachLayout = (LinearLayout) findViewById(R.id.teach_layout);
        teachLayout.setOnClickListener(this);
        userLayout = (LinearLayout) findViewById(R.id.me_layout);
        userLayout.setOnClickListener(this);
    }

    private void initData() {
        Fragment home = new HomeFragment();
        Fragment teach = new TeachFragment();
        Fragment music = new MusicFragment();
        Fragment user = new UserFragment();
        mList.add(home);
        mList.add(teach);
        mList.add(music);
        mList.add(user);
        manager = getSupportFragmentManager();
        adapter = new MyPagerAdapter(manager, mList);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout:
                viewPager.setCurrentItem(0);
                updataViewPager(true, false, false, false);
                break;
            case R.id.teach_layout:
                viewPager.setCurrentItem(1);
                updataViewPager(false, true, false, false);
                break;
            case R.id.music_layout:
                viewPager.setCurrentItem(2);
                updataViewPager(false, false, true, false);
                break;
            case R.id.me_layout:
                viewPager.setCurrentItem(3);
                updataViewPager(false, false, false, true);
                break;
        }
    }

    private void updataViewPager(boolean home, boolean teach, boolean music, boolean user) {
        homeLayout.setSelected(home);
        teachLayout.setSelected(teach);
        musicLayout.setSelected(music);
        userLayout.setSelected(user);
    }
}
