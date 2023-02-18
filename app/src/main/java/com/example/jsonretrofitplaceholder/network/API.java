package com.example.jsonretrofitplaceholder.network;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

   String BASE_URL="https://fakestoreapi.com/"; //https://fakestoreapi.com/

   @GET("products")     //products
    Call<List<PhotosResults>> getPhotos();



}
