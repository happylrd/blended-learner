package io.happylrd.childishscorems.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.adapter.GsonUTCDateAdapter;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateActActivity extends AppCompatActivity {

    public static final String ACT_BEAN_ID = "act_bean_id";

    private ActivityBean mActBean = new ActivityBean();

    private Toolbar mToolbar;

    private EditText mNameEdit;
    private EditText mScoreEdit;
    private EditText mDescEdit;
    private CheckBox mHasPassedCheck;

    private TextView mStartTimeText;
    private TextView mEndTimeText;

    private Button mSubmitBtn;

    public static Intent newIntent(Context context, Integer actBeanId) {
        Intent intent = new Intent(context, UpdateActActivity.class);
        intent.putExtra(ACT_BEAN_ID, actBeanId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_act);

        Intent intent = getIntent();
        Integer actBeanId = intent.getIntExtra(ACT_BEAN_ID, 0);

        initView();
        initData(actBeanId);
        initListener();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNameEdit = (EditText) findViewById(R.id.et_act_name);
        mScoreEdit = (EditText) findViewById(R.id.et_act_score);
        mDescEdit = (EditText) findViewById(R.id.et_act_desc);
        mHasPassedCheck = (CheckBox) findViewById(R.id.cb_act_has_passed);
        mStartTimeText = (TextView) findViewById(R.id.tv_act_start_time);
        mEndTimeText = (TextView) findViewById(R.id.tv_act_end_time);
        mSubmitBtn = (Button) findViewById(R.id.btn_submit);

        mToolbar.setTitle("修改活动");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initListener() {
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitChange();
            }
        });
    }

    private void submitChange() {
        mActBean.setName(mNameEdit.getText().toString().trim());
        mActBean.setScore(mScoreEdit.getText().toString().trim());
        mActBean.setDesc(mDescEdit.getText().toString().trim());
        mActBean.setHasPassed(mHasPassedCheck.isChecked());
        mActBean.setStartTime(new Date());
        mActBean.setEndTime(new Date());

        LogUtil.i(mActBean.getId() + "");
        LogUtil.i(mActBean.getName() + "");
        LogUtil.i(mActBean.getScore() + "");
        LogUtil.i(mActBean.getDesc() + "");
        LogUtil.i(mActBean.getHasPassed() + "");
        LogUtil.i(mActBean.getStartTime() + "");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);
        Call<ActivityBean> actBeanCall = service.updateActBean(mActBean.getId(), mActBean);
        actBeanCall.enqueue(new Callback<ActivityBean>() {
            @Override
            public void onResponse(Call<ActivityBean> call, Response<ActivityBean> response) {
                ActivityBean activityBean = response.body();
                LogUtil.i("put actBean success" + activityBean.getId());
                //TODO: do something
            }

            @Override
            public void onFailure(Call<ActivityBean> call, Throwable t) {

            }
        });
    }

    private void initData(Integer actBeanId) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

        Call<ActivityBean> actBeanCall = service.getActBean(actBeanId);
        actBeanCall.enqueue(new Callback<ActivityBean>() {
            @Override
            public void onResponse(Call<ActivityBean> call, Response<ActivityBean> response) {
                mActBean = response.body();

                mNameEdit.setText(mActBean.getName());
                mScoreEdit.setText(mActBean.getScore());
                mDescEdit.setText(mActBean.getDesc());
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
