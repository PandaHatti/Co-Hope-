package com.example.cohopetrial3;

import com.example.cohopetrial3.parameter.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface {
    @GET("top-headlines")
    Call<Headlines>getHeadlines(
        @Query("country") String country,
                @Query("apikey") String apikey
    );
}
