package com.chloetseng.zoo.network

import com.chloetseng.zoo.BuildConfig
import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.data.ExhibitResult
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.data.PlantResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val HOST_NAME = "data.taipei"
private const val API_VERSION = "v1"
private const val BASE_URL = "https://$HOST_NAME/api/$API_VERSION/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("dataset/{dataType}")
    suspend fun getExhibitList(@Path("dataType") type: String, @Query("scope") scope: String, @Query("Content-Type") content: String = "application/json"): ExhibitResult

    @GET("dataset/{dataType}")
    suspend fun getPlantList(@Path("dataType") type: String, @Query("scope") scope: String): PlantResult
}

object ZooApi {
    val retrofitService : ApiService by lazy { retrofit.create(ApiService::class.java) }
}