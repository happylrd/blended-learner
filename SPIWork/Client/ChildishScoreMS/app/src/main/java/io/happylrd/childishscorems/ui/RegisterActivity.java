package io.happylrd.childishscorems.ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.Student;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mRealnameWrapper;
    private TextInputLayout mUsernameWrapper;
    private TextInputLayout mPasswordWrapper;

    private EditText et_realname;
    private EditText et_username;
    private EditText et_password;

    private Button mRegisterBtn;
    private TextView mGotoLoginText;

    public static Intent newIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        initListener();
    }

    private void initView() {
        mRealnameWrapper = (TextInputLayout) findViewById(R.id.til_realname_wrapper);
        mUsernameWrapper = (TextInputLayout) findViewById(R.id.til_username_wrapper);
        mPasswordWrapper = (TextInputLayout) findViewById(R.id.til_password_wrapper);

        et_realname = mRealnameWrapper.getEditText();
        et_username = mUsernameWrapper.getEditText();
        et_password = mPasswordWrapper.getEditText();

        mRegisterBtn = (Button) findViewById(R.id.btn_register);
        mGotoLoginText = (TextView) findViewById(R.id.tv_goto_login);
    }

    private void initListener() {
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String realname = et_realname.getText().toString().trim();
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                doRegister(realname, username, password);
            }
        });

        mGotoLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LoginActivity.newIntent(RegisterActivity.this));
                finish();
            }
        });
    }

    private void doRegister(final String realname, final String username, final String password) {
        if (!TextUtils.isEmpty(realname) && !TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {

            Student student = new Student();
            student.setRealname(realname);
            student.setUsername(username);
            student.setPassword(password);
            student.setSchool(StaticClass.DEFAULT_SCHOOL);
            student.setMajor(StaticClass.DEFAULT_MAJOR);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

            Call<Student> studentCall = service.createStudent(student);
            studentCall.enqueue(new Callback<Student>() {
                @Override
                public void onResponse(Call<Student> call, Response<Student> response) {
                    Student postStudent = response.body();
                    LogUtil.i("Student info:" + postStudent.getRealname());

                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

                    startActivity(LoginActivity.newIntent(RegisterActivity.this));
                }

                @Override
                public void onFailure(Call<Student> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "请检查网络环境", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
        }
    }
}
