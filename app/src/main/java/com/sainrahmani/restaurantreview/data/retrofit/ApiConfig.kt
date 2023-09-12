package com.sainrahmani.restaurantreview.data.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

class ApiConfig {

    companion object{
        fun getApiService(): ApiService{

            // jika belum dipublikasikan aplikasinya maka menggunakan syntax dibawah ini
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://restaurant-api.dicoding.dev/")
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)

            // jika sudah dipublikasikan maka menggunakan syntax seperti dibawah ini
            //  val loggingInterceptor = if(BuildConfig.DEBUG) {
            //      HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            //  } else {
            //      HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            //  }
        }
    }

}