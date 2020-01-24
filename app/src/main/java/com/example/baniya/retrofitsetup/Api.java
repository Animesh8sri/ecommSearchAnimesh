package com.example.baniya.retrofitsetup;

import com.example.baniya.search.SearchPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api
{

    String BASE_URL = "http://172.16.20.25:8086";

    @GET("/Products/product/desc/{j}/")
    Call<List<SearchPOJO>> getList(@Path("j") String str);

}
