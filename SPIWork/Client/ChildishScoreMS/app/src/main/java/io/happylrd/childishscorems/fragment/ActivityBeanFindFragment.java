package io.happylrd.childishscorems.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.adapter.ActivityBeanAdapter;
import io.happylrd.childishscorems.api.NaiveScoreMSService;
import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.utils.LogUtil;
import io.happylrd.childishscorems.utils.StaticClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityBeanFindFragment extends Fragment {

    private ActivityBeanAdapter mAdapter;

    private RecyclerView mRecyclerView;

    private MaterialSearchView mSearchView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_act_find, null);

        initView(view);
        initListener();
        initData();

        return view;
    }

    private void initData() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        //TODO: will be modified later
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NaiveScoreMSService service = retrofit.create(NaiveScoreMSService.class);

        Call<List<ActivityBean>> listActBeanCall = service.listActBean();
        listActBeanCall.enqueue(new Callback<List<ActivityBean>>() {
            @Override
            public void onResponse(Call<List<ActivityBean>> call, Response<List<ActivityBean>> response) {

                List<ActivityBean> actBeanList = response.body();

//                LogUtil.i(actBeanList.get(0).getStartTime().toString());

                mAdapter = new ActivityBeanAdapter(actBeanList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<ActivityBean>> call, Throwable t) {

            }
        });
    }

    private void initView(View view) {
        mSearchView = (MaterialSearchView) view.findViewById(R.id.search_view);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    private void initListener() {
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO: will be written after back-end add the fuzzy search api support
                LogUtil.i("QuerySubmit:" + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO: for instant search
                return false;
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(item);
    }
}
