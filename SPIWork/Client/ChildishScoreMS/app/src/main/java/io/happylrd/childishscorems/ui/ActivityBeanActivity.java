package io.happylrd.childishscorems.ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ActivityBeanActivity extends AppCompatActivity {

    public static final String ACTIVITY_BEAN_ID = "activity_bean_id";

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private ImageView mActivityBeanImage;
    private TextView mNameText;
    private TextView mScoreText;
    private TextView mDescText;
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
        initData(activityBeanId);
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
        mActivityBeanImage = (ImageView) findViewById(R.id.iv_image);
        mNameText = (TextView) findViewById(R.id.tv_name);
        mScoreText = (TextView) findViewById(R.id.tv_score);
        mDescText = (TextView) findViewById(R.id.tv_desc);
        mStartTimeText = (TextView) findViewById(R.id.tv_start_time);
        mEndTimeText = (TextView) findViewById(R.id.tv_end_time);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
                    ActivityBean activityBean = gson.fromJson(jsonData, ActivityBean.class);

                    LogUtil.i(activityBean.getName());

                    mCollapsingToolbarLayout.setTitle(activityBean.getName());

                    //TODO: add image support later
                    Glide.with(ActivityBeanActivity.this)
                            .load(R.drawable.default_activitybean_image)
                            .into(mActivityBeanImage);

                    mNameText.setText(activityBean.getName());
                    mScoreText.setText(activityBean.getScore());
                    mDescText.setText(activityBean.getDesc());
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
