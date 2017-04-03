package io.happylrd.childishscorems.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.adapter.ActivityBeanAdapter;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FinderFragment extends Fragment {

    private ActivityBeanAdapter mAdapter;

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finder, null);

        initView(view);
        initData();

        return view;
    }

    private void initData() {
        //TODO: will be modified later
        Retrofit retrofit = StaticClass.getRetrofitInstance();

        NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

        Call<ResponseBody> bodyCall = service.findActivities();
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String jsonData = response.body().string();

                    LogUtil.i(jsonData);

                    JsonParser parser = new JsonParser();
                    JsonArray array = parser.parse(jsonData).getAsJsonArray();
                    Gson gson = new Gson();
                    List<ActivityBean> activityBeanList = new ArrayList<>();
                    for (JsonElement element : array) {
                        ActivityBean activityBean = gson.fromJson(element, ActivityBean.class);

                        LogUtil.i(activityBean.getName());

                        activityBeanList.add(activityBean);
                    }
                    mAdapter = new ActivityBeanAdapter(activityBeanList);
                    mRecyclerView.setAdapter(mAdapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
