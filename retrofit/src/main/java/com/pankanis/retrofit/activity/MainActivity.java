package com.pankanis.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pankanis.retrofit.R;
import com.pankanis.retrofit.model.MovieModel;
import com.pankanis.retrofit.model.MovieResponse;
import com.pankanis.retrofit.rest.ApiClient;
import com.pankanis.retrofit.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<MovieResponse> call = apiInterface.getTopRatedMovie(this.getString(R.string.apikey));
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<MovieModel> movieModels = response.body().getResults();
                Log.e(TAG, " Number of movies received ==> " + movieModels.size());
                response.code();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

                Log.e(TAG, "Failure reason ==> " + t.toString());
            }
        });
    }
}
