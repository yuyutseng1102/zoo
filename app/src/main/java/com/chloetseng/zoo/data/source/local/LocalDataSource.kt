package com.chloetseng.zoo.data.source.local

import android.content.Context
import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.data.source.DataSource
import com.chloetseng.zoo.data.Result

class LocalDataSource(context: Context) : DataSource {
    override suspend fun getExhibitList(type: String, scope: String): Result<List<Exhibit>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlantList(type: String, scope: String): Result<List<Plant>> {
        TODO("Not yet implemented")
    }
}