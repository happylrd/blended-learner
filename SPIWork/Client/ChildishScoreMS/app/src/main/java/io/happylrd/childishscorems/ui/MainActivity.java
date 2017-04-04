package io.happylrd.childishscorems.ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.fragment.ActivityBeanFindFragment;
import io.happylrd.childishscorems.fragment.UserFragment;
import io.happylrd.childishscorems.utils.LogUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<String> mTitleList;
    private List<Fragment> mFragmentList;

    private FloatingActionButton fab_setting;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mTitleList = new ArrayList<>();
        //TODO: need to be replaced with the string resource file later
        mTitleList.add("发现");
        mTitleList.add("我的");

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new ActivityBeanFindFragment());
        mFragmentList.add(new UserFragment());
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        fab_setting = (FloatingActionButton) findViewById(R.id.fab_setting);

        mViewPager.setOffscreenPageLimit(mFragmentList.size());

        fab_setting.setVisibility(View.GONE);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitleList.get(position);
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);

        fab_setting.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LogUtil.i("position:" + position);
                if (position == 0) {
                    fab_setting.setVisibility(View.GONE);
                } else {
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_setting:
                //TODO: do something
        }
    }
}
