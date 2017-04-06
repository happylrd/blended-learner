package io.happylrd.childishscorems.ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.model.Student;
import io.happylrd.childishscorems.model.StudentActivityBean;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.ShareUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityBeanActivity extends AppCompatActivity {

    public static final String ACTIVITY_BEAN_ID = "activity_bean_id";

    private ActivityBean activityBean;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private FloatingActionButton mJoinFAB;

    private ImageView mActivityBeanImage;
    private TextView mNameText;
    private TextView mScoreText;
    private TextView mDescText;
    private CheckBox mStateCheck;
    private TextView mStartTimeText;
    private TextView mEndTimeText;

    public static Intent newIntent(Context context, Integer activityBeanId) {
        Intent intent = new Intent(context, ActivityBeanActivity.class);

        intent.putExtra(ACTIVITY_BEAN_ID, activityBeanId);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_bean);

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
        mJoinFAB = (FloatingActionButton) findViewById(R.id.fab_join);
        mActivityBeanImage = (ImageView) findViewById(R.id.iv_image);
        mNameText = (TextView) findViewById(R.id.tv_name);
        mScoreText = (TextView) findViewById(R.id.tv_score);
        mDescText = (TextView) findViewById(R.id.tv_desc);
        mStateCheck = (CheckBox) findViewById(R.id.cb_state);
        mStartTimeText = (TextView) findViewById(R.id.tv_start_time);
        mEndTimeText = (TextView) findViewById(R.id.tv_end_time);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initListener() {
        mStateCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LogUtil.i("isChecked:" + isChecked);
            }
        });

        mJoinFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * get current user id
                 * get current activity id
                 * POST to studentactivity
                 */
                Student student = ShareUtil.getStudent(ActivityBeanActivity.this,
                        StaticClass.SHARE_CURRENT_USER, "");

                StudentActivityBean saBean = new StudentActivityBean();
                saBean.setStudentId(student.getId());
                saBean.setActivityId(activityBean.getId());
                saBean.setHasJoined(true);

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
                        //TODO: do something
                    }

                    @Override
                    public void onFailure(Call<StudentActivityBean> call, Throwable t) {

                    }
                });
            }
        });
    }

    private void initData(Integer activityBeanId) {
        Retrofit retrofit = StaticClass.getRetrofitInstance();

        NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

        Call<ResponseBody> bodyCall = service.findOneActivityBean(activityBeanId);
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Gson gson = new Gson();
                    String jsonData = response.body().string();
                    activityBean = gson.fromJson(jsonData, ActivityBean.class);

                    LogUtil.i(activityBean.getName());

                    mCollapsingToolbarLayout.setTitle(activityBean.getName());

                    //TODO: add image support later
                    Glide.with(ActivityBeanActivity.this)
                            .load(R.drawable.default_activitybean_image)
                            .into(mActivityBeanImage);

                    mNameText.setText(activityBean.getName());
                    mScoreText.setText(activityBean.getScore());
                    mDescText.setText(activityBean.getDesc());
                    mStateCheck.setChecked(activityBean.getState() != 0);
                    mStartTimeText.setText(activityBean.getStartTime());
                    mEndTimeText.setText(activityBean.getEndTime());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
