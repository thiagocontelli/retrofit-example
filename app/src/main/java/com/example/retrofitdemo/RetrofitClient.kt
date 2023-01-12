package com.example.retrofitdemo

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"

        fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder().build()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL).client(http)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return INSTANCE
        }

        fun <S> createService(x: Class<S>): S {
            return getRetrofitInstance().create(x)
        }
    }


}