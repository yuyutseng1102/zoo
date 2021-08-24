package com.chloetseng.zoo.data.source.remote

import android.util.Log
import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.data.source.DataSource
import com.chloetseng.zoo.data.Result
import com.chloetseng.zoo.isInternetConnected
import com.chloetseng.zoo.network.ZooApi

object RemoteDataSource: DataSource {
    override suspend fun getExhibitList(type: String, scope: String): Result<List<Exhibit>> {
        if (!isInternetConnected()) {
            return Result.Fail("Internet not connected")
        }

        return try {
            // this will run on a thread managed by Retrofit
            val listResult = ZooApi.retrofitService.getExhibitList(type = type, scope = scope)
            Result.Success(listResult)

        } catch (e: Exception) {
            Log.w("Chloe", "[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }


    override suspend fun getPlantList(type: String, scope: String): Result<List<Plant>> {
        if (!isInternetConnected()) {
            return Result.Fail("Internet not connected")
        }

        return try {
            // this will run on a thread managed by Retrofit
            val listResult = ZooApi.retrofitService.getPlantList(type = type, scope = scope)
            Result.Success(listResult)

        } catch (e: Exception) {
            Log.w("Chloe", "[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }
}