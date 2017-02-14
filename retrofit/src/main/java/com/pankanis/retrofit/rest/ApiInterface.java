package com.pankanis.retrofit.rest;


import com.pankanis.retrofit.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sumit.ingewar on 2/13/2017.
 */

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovie(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Query("id") int id, @Query("api_key") String apiKey);
}
