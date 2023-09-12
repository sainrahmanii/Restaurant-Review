package com.sainrahmani.restaurantreview.data.retrofit

import retrofit2.Call
import com.sainrahmani.restaurantreview.data.response.ResponseRestaurant
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("detail/{id}")
    fun getRestaurant(
        @Path("id") id: String
    ): Call<ResponseRestaurant>
}