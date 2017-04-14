package io.happylrd.childishscorems.api;

import java.util.List;

import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.model.StudentActivityBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NaiveScoreMSService {
    @GET("users/students/{username}")
    Call<ResponseBody> findOneStudent(@Path("username") String username);

    @GET("users/teachers/{username}")
    Call<ResponseBody> findOneTeacher(@Path("username") String username);

    @GET("activities")
    Call<List<ActivityBean>> listActBean();

//    @GET("activities/{id}")
//    Call<ResponseBody> findOneActivityBean(@Path("id") Integer id);

    @GET("activities/{id}")
    Call<ActivityBean> getActBean(@Path("id") Integer id);

    @POST("activities/")
    Call<ActivityBean> createActBean(@Body ActivityBean activityBean);

    @POST("studentactivities/")
    Call<StudentActivityBean> createSABean(@Body StudentActivityBean studentActivityBean);
}
