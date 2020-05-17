package com.lazday.retrofitsetup.retrofit;

import com.lazday.retrofitsetup.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("data.php") Call<MainModel> getData();
}
