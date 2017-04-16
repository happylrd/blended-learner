package io.happylrd.childishscorems.ui;

import android.app.ProgressDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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

    private TextInputLayout mUsernameWrapper;
    private TextInputLayout mPasswordWrapper;

    private EditText et_username;
    private EditText et_password;

    private Button mLoginBtn;
    private TextView mAdministratorText;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();
    }

    private void initView() {
        mUsernameWrapper = (TextInputLayout) findViewById(R.id.til_username_wrapper);
        mPasswordWrapper = (TextInputLayout) findViewById(R.id.til_password_wrapper);

        et_username = mUsernameWrapper.getEditText();
        et_password = mPasswordWrapper.getEditText();

        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mAdministratorText = (TextView) findViewById(R.id.tv_administrator);
    }

    private void initListener() {
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProgressDialog();

                //TODO: add validation
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

        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() > 0) {
                    if (charSequence.charAt(0) != '2') {
                        mUsernameWrapper.setError("用户名不合法");
                        mUsernameWrapper.setErrorEnabled(true);
                    } else {
                        mUsernameWrapper.setErrorEnabled(false);
                    }
                } else {
                    mUsernameWrapper.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

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

                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            mProgressDialog.dismiss();

                            startActivity(MainActivity.newIntent(LoginActivity.this));
                        } else {
                            Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                            mProgressDialog.dismiss();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "请检查网络环境", Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                }
            });
        } else {
            Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
            mProgressDialog.dismiss();
        }
    }

    private void startProgressDialog() {
        mProgressDialog = new ProgressDialog(LoginActivity.this);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }
}
