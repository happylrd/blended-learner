package io.happylrd.childishscorems.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

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

public class ScoreFragment extends Fragment {

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;

    private ImageView mAvatarImage;
    private TextView mTotalScoreText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, null);

        initView(view);
        initData();

        return view;
    }

    private void initView(View view) {
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)
                view.findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mAvatarImage = (ImageView) view.findViewById(R.id.civ_avatar);
        mTotalScoreText = (TextView) view.findViewById(R.id.tv_total_score);
    }

    private void initData() {
        Glide.with(getActivity())
                .load(R.drawable.default_activitybean_image)
                .into(mAvatarImage);

        Student student = ShareUtil.getStudent(getActivity(),
                StaticClass.SHARE_CURRENT_USER, "");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                .build();
        NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

        Call<ResponseBody> totalScoreCall = service.getTotalScore(student.getUsername());
        totalScoreCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String jsonData = response.body().string();
                    LogUtil.i("totalScore:" + jsonData);
                    JSONObject jsonObject = new JSONObject(jsonData);
                    String totalScore = jsonObject.getString("score__sum");
                    mTotalScoreText.setText(totalScore);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
