package io.happylrd.childishscorems.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.adapter.GsonUTCDateAdapter;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.utils.DateUtil;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddActActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private EditText mNameEdit;
    private EditText mScoreEdit;
    private EditText mDescEdit;
    private CheckBox mHasPassedCheck;

    private TextView mStartTimeDateText;
    private TextView mStartTimeTimeText;
    private TextView mEndTimeDateText;
    private TextView mEndTimeTimeText;

    private Button mSubmitBtn;

    public static Intent newIntent(Context context) {
        return new Intent(context, AddActActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_act);

        initView();
        initListener();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNameEdit = (EditText) findViewById(R.id.et_act_name);
        mScoreEdit = (EditText) findViewById(R.id.et_act_score);
        mDescEdit = (EditText) findViewById(R.id.et_act_desc);
        mHasPassedCheck = (CheckBox) findViewById(R.id.cb_act_has_passed);
        mStartTimeDateText = (TextView) findViewById(R.id.tv_act_start_time_date);
        mStartTimeTimeText = (TextView) findViewById(R.id.tv_act_start_time_time);
        mEndTimeDateText = (TextView) findViewById(R.id.tv_act_end_time_date);
        mEndTimeTimeText = (TextView) findViewById(R.id.tv_act_end_time_time);
        mSubmitBtn = (Button) findViewById(R.id.btn_submit);

        mToolbar.setTitle("添加活动");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initListener() {
        View.OnClickListener showDateListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View vv = v;

                Calendar now = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddActActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String dateStr = year + "-"
                                + StaticClass.autoFillZero((monthOfYear + 1), 2) + "-"
                                + StaticClass.autoFillZero(dayOfMonth, 2);
                        if (vv.getId() == R.id.tv_act_start_time_date) {
                            mStartTimeDateText.setText(dateStr);
                        } else {
                            mEndTimeDateText.setText(dateStr);
                        }
                    }
                }, now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
            }
        };

        View.OnClickListener showTimeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View vv = v;

                Calendar now = Calendar.getInstance();

                TimePickerDialog timePickerDialog = new TimePickerDialog(AddActActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String timeStr = StaticClass.autoFillZero(hourOfDay, 2) + ":"
                                + StaticClass.autoFillZero(minute, 2)
                                + ":00";
                        if (vv.getId() == R.id.tv_act_start_time_time) {
                            mStartTimeTimeText.setText(timeStr);
                        } else {
                            mEndTimeTimeText.setText(timeStr);
                        }
                    }
                }, now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true);

                timePickerDialog.show();
            }
        };

        mStartTimeDateText.setOnClickListener(showDateListener);
        mEndTimeDateText.setOnClickListener(showDateListener);

        mStartTimeTimeText.setOnClickListener(showTimeListener);
        mEndTimeTimeText.setOnClickListener(showTimeListener);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set act data
                ActivityBean actBean = new ActivityBean();
                actBean.setName(mNameEdit.getText().toString().trim());
                actBean.setScore(mScoreEdit.getText().toString().trim());
                actBean.setDesc(mDescEdit.getText().toString().trim());
                actBean.setHasPassed(mHasPassedCheck.isChecked());

                String startTimeStr = mStartTimeDateText.getText().toString().trim() + "T"
                        + mStartTimeTimeText.getText().toString().trim();
                try {
                    actBean.setStartTime(DateUtil.parse(startTimeStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String endTimeStr = mEndTimeDateText.getText().toString().trim() + "T"
                        + mEndTimeTimeText.getText().toString().trim();
                try {
                    actBean.setEndTime(DateUtil.parse(endTimeStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // interact with api server
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
                NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

                Call<ActivityBean> actBeanCall = service.createActBean(actBean);
                actBeanCall.enqueue(new Callback<ActivityBean>() {
                    @Override
                    public void onResponse(Call<ActivityBean> call, Response<ActivityBean> response) {
                        ActivityBean activityBean = response.body();
                        LogUtil.i(activityBean.getName());

                        //TODO: give tips and finish the activity.
                    }

                    @Override
                    public void onFailure(Call<ActivityBean> call, Throwable t) {
                        LogUtil.i(t.getMessage());
                    }
                });
            }
        });
    }
}
