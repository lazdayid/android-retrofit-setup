package com.lazday.retrofitsetup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lazday.retrofitsetup.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataFromApi();
    }

    private void getDataFromApi() {

        ApiService.endpoint().getData()
                .enqueue(new Callback<MainModel>() {
                    @Override
                    public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                        Log.d( TAG, response.toString());
                        if (response.isSuccessful()) {
                            List<MainModel.Result> results = response.body().getResult();
                            Log.d(TAG, results.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<MainModel> call, Throwable t) {
                        Log.d( TAG, t.toString());

                    }
                });

    }
}
