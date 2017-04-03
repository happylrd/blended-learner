package io.happylrd.childishscorems.utils;

import retrofit2.Retrofit;

public class StaticClass {

    private static final String NAIVE_SCORE_MS_IP = "10.8.173.184";
    private static final String NAIVE_SCORE_MS_PORT = "8000";
    public static final String NAIVE_SCORE_MS_BASE_URL = "http://" + NAIVE_SCORE_MS_IP + ":" + NAIVE_SCORE_MS_PORT + "/";
    public static final String ADMIN_MS_URL = NAIVE_SCORE_MS_BASE_URL + "admin/";

    //TODO: will be encapsulated later, just for naive score ms api now.
    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(StaticClass.NAIVE_SCORE_MS_BASE_URL)
                .build();
    }
}
