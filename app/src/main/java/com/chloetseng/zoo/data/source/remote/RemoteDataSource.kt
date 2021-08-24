package com.chloetseng.zoo.data.source.remote

import android.util.Log
import com.chloetseng.zoo.data.*
import com.chloetseng.zoo.data.source.DataSource
import com.chloetseng.zoo.isInternetConnected
import com.chloetseng.zoo.network.ZooApi

object RemoteDataSource: DataSource {
    override suspend fun getExhibitList(type: String, scope: String): Result<ExhibitResult> {

        Log.d("Chloe", "call api")

        if (!isInternetConnected()) {
            return Result.Fail("Internet not connected")
        }

        return try {
            // this will run on a thread managed by Retrofit
            val listResult = ZooApi.retrofitService.getExhibitList(type = type, scope = scope)
            Log.d("Chloe", "call api listResult is $listResult")
            Result.Success(listResult)


        } catch (e: Exception) {
            Log.w("Chloe", "[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }

    override suspend fun getExhibit(type: String, scope: String, id: Int): Result<Exhibit> {

        Log.d("Chloe", "call api")

        if (!isInternetConnected()) {
            return Result.Fail("Internet not connected")
        }

        return try {
            // this will run on a thread managed by Retrofit
            val listResult = ZooApi.retrofitService.getExhibitList(type = type, scope = scope)
            val result = listResult.result.results.filter { it.id == id }
            Result.Success(result[0])

        } catch (e: Exception) {
            Log.w("Chloe", "[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }


    override suspend fun getPlantList(type: String, scope: String): Result<PlantResult> {
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