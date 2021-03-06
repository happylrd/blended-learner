package io.happylrd.childishscorems.api;

import java.util.List;

import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.model.Student;
import io.happylrd.childishscorems.model.StudentActivityBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface NaiveScoreMSService {
    @GET("users/students/{username}")
    Call<ResponseBody> findOneStudent(@Path("username") String username);

    @POST("users/students/")
    Call<Student> createStudent(@Body Student student);

    @GET("activities")
    Call<List<ActivityBean>> listActBean();

    @POST("activities/")
    Call<ActivityBean> createActBean(@Body ActivityBean activityBean);

    @GET("activities/{id}")
    Call<ActivityBean> getActBean(@Path("id") Integer id);

    @PUT("activities/{id}/")
    Call<ActivityBean> updateActBean(@Path("id") Integer id, @Body ActivityBean actBean);

    @POST("studentactivities/")
    Call<StudentActivityBean> createSABean(@Body StudentActivityBean studentActivityBean);

    //TODO: will be improved later
    @GET("score/students/{username}/sum/")
    Call<ResponseBody> getTotalScore(@Path("username") String username);
}
