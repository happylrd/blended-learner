package io.happylrd.childishscorems.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.adapter.ViewPagerAdapter;
import io.happylrd.childishscorems.fragment.ActivityBeanFindFragment;
import io.happylrd.childishscorems.fragment.UserFragment;
import io.happylrd.childishscorems.utils.LogUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private MenuItem mPrevMenuItem;

    private FloatingActionsMenu mFABMenu;
    private FloatingActionButton mAddActivityFAB;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);

        mFABMenu = (FloatingActionsMenu) findViewById(R.id.fab_menu);
        mAddActivityFAB = (FloatingActionButton) findViewById(R.id.fab_add_activity);

        setupWithViewPager(mViewPager);
    }

    private void initListener() {
        mFABMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {

            }

            @Override
            public void onMenuCollapsed() {

            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_activity:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.item_score:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.item_find:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.item_my:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        mAddActivityFAB.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mPrevMenuItem != null) {
                    mPrevMenuItem.setChecked(false);
                } else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                LogUtil.i("position:" + position);

                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
                mPrevMenuItem = mBottomNavigationView.getMenu().getItem(position);

                //TODO: will be modified later
                if (position == 0) {
                    mFABMenu.setVisibility(View.VISIBLE);
                } else {
                    mFABMenu.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupWithViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ActivityBeanFindFragment());
        adapter.addFragment(new UserFragment());
        adapter.addFragment(new UserFragment());
        adapter.addFragment(new UserFragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_activity:
                startActivity(AddActActivity.newIntent(this));
                mFABMenu.collapse();
        }
    }
}
