package io.happylrd.childishscorems.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.Student;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.ShareUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;

    private Button mLoginBtn;
    private TextView mAdministratorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();
    }

    private void initView() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mAdministratorText = (TextView) findViewById(R.id.tv_administrator);
    }

    private void initListener() {
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                doLogin(username, password);
            }
        });

        mAdministratorText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AdministratorActivity
                        .newIntent(LoginActivity.this));
                finish();
            }
        });
    }

    public void doLogin(final String username, final String password) {
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                    .build();

            NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

            Call<ResponseBody> bodyCall = service.findOneStudent(username);
            bodyCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        Gson gson = new Gson();
                        String jsonData = response.body().string();
                        Student student = gson.fromJson(jsonData, Student.class);

                        LogUtil.i(student.getUsername());

                        if (password.equals(student.getPassword())) {
                            ShareUtil.putStudent(LoginActivity.this,
                                    StaticClass.SHARE_CURRENT_USER, student);

                            startActivity(MainActivity.newIntent(LoginActivity.this));
                        } else {
                            Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkForTeacher(final String username, final String password) {
        //TODO: implement the teacher check logic later
    }
}
