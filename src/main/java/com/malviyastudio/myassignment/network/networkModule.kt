package com.malviyastudio.myassignment.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object networkModule {
    private const val BASE_URL = "https://run.mocky.io/" // Replace with your actual API base URL

    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout((60 * 2).toLong(), TimeUnit.SECONDS)
            .connectTimeout((60 * 2).toLong(), TimeUnit.SECONDS)
            .writeTimeout((60 * 2).toLong(), TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}
