package io.happylrd.childishscorems.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NaiveScoreMSService {
    @GET("users/students/{username}")
    Call<ResponseBody> findOneStudent(@Path("username") String username);

    @GET("activities")
    Call<ResponseBody> findActivities();
}
