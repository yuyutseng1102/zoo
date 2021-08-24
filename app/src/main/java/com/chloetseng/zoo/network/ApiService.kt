package com.chloetseng.zoo.network

import androidx.databinding.ktx.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val HOST_NAME = "data.taipei"
private const val API_VERSION = "v1"
private const val BASE_URL = "https://$HOST_NAME/api/$API_VERSION/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
