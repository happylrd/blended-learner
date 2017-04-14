package io.happylrd.childishscorems.ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.model.Student;
import io.happylrd.childishscorems.model.StudentActivityBean;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.ShareUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActDetailActivity extends AppCompatActivity {

    public static final String ACTIVITY_BEAN_ID = "activity_bean_id";

    private ActivityBean mActBean;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;

    private FrameLayout mFrameLayout;
    private FloatingActionsMenu mFABMenu;
    private FloatingActionButton mJoinActFAB;
    private FloatingActionButton mModifyActFAB;

    private ImageView mActivityBeanImage;
    private TextView mNameText;
    private TextView mScoreText;
    private TextView mDescText;
    private CheckBox mHasPassedCheck;
    private TextView mStartTimeText;
    private TextView mEndTimeText;

    public static Intent newIntent(Context context, Integer activityBeanId) {
        Intent intent = new Intent(context, ActDetailActivity.class);

        intent.putExtra(ACTIVITY_BEAN_ID, activityBeanId);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_detail);

        Intent intent = getIntent();
        Integer activityBeanId = intent.getIntExtra(ACTIVITY_BEAN_ID, 0);

        initView();
        initListener();
        initData(activityBeanId);
    }

    private void initView() {
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mActivityBeanImage = (ImageView) findViewById(R.id.iv_image);
        mNameText = (TextView) findViewById(R.id.tv_name);
        mScoreText = (TextView) findViewById(R.id.tv_score);
        mDescText = (TextView) findViewById(R.id.tv_desc);
        mHasPassedCheck = (CheckBox) findViewById(R.id.cb_has_passed);
        mStartTimeText = (TextView) findViewById(R.id.tv_start_time);
        mEndTimeText = (TextView) findViewById(R.id.tv_end_time);

        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        mFABMenu = (FloatingActionsMenu) findViewById(R.id.fab_menu);
        mJoinActFAB = (FloatingActionButton) findViewById(R.id.fab_join_act);
        mModifyActFAB = (FloatingActionButton) findViewById(R.id.fab_modify_act);

        mFrameLayout.getBackground().setAlpha(0);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initListener() {
        mFABMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                mFrameLayout.getBackground().setAlpha(240);
                mFrameLayout.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        mFABMenu.collapse();
                        return true;
                    }
                });
            }

            @Override
            public void onMenuCollapsed() {
                mFrameLayout.getBackground().setAlpha(0);
                mFrameLayout.setOnTouchListener(null);
            }
        });


        mHasPassedCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LogUtil.i("isChecked:" + isChecked);
            }
        });

        mJoinActFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinAct();

                mFrameLayout.getBackground().setAlpha(0);
                mFABMenu.collapse();
            }
        });

        mModifyActFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyAct();

                mFrameLayout.getBackground().setAlpha(0);
                mFABMenu.collapse();
            }
        });
    }

    /**
     * get current user id
     * get current activity id
     * POST to studentactivity
     */
    private void joinAct() {
        Student student = ShareUtil.getStudent(ActDetailActivity.this,
                StaticClass.SHARE_CURRENT_USER, "");

        StudentActivityBean saBean = new StudentActivityBean();
        saBean.setStudentId(student.getId());
        saBean.setActivityId(mActBean.getId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

        Call<StudentActivityBean> saBeanCall = service.createSABean(saBean);
        saBeanCall.enqueue(new Callback<StudentActivityBean>() {
            @Override
            public void onResponse(Call<StudentActivityBean> call, Response<StudentActivityBean> response) {
                StudentActivityBean studentActivityBean = response.body();

                LogUtil.i("post saBean success" + studentActivityBean.getId());
                // TODO: do something
            }

            @Override
            public void onFailure(Call<StudentActivityBean> call, Throwable t) {

            }
        });
    }

    private void modifyAct() {
        startActivity(new Intent(UpdateActActivity
                .newIntent(ActDetailActivity.this, mActBean.getId())));
    }

    private void initData(Integer activityBeanId) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

        Call<ActivityBean> actBeanCall = service.getActBean(activityBeanId);
        actBeanCall.enqueue(new Callback<ActivityBean>() {
            @Override
            public void onResponse(Call<ActivityBean> call, Response<ActivityBean> response) {
                mActBean = response.body();
                LogUtil.i(mActBean.getName());

                mCollapsingToolbarLayout.setTitle(mActBean.getName());

                //TODO: add image support later
                Glide.with(ActDetailActivity.this)
                        .load(R.drawable.default_activitybean_image)
                        .into(mActivityBeanImage);

                mNameText.setText(mActBean.getName());
                mScoreText.setText(mActBean.getScore());
                mDescText.setText(mActBean.getDesc());
                mHasPassedCheck.setChecked(mActBean.getHasPassed());

                mStartTimeText.setText(mActBean.getStartTime().toString());
                mEndTimeText.setText(mActBean.getEndTime().toString());
            }

            @Override
            public void onFailure(Call<ActivityBean> call, Throwable t) {

            }
        });
    }
}
