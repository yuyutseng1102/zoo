package com.chloetseng.zoo.data.source.local

import android.content.Context
import com.chloetseng.zoo.data.*
import com.chloetseng.zoo.data.source.DataSource

class LocalDataSource(context: Context) : DataSource {
    override suspend fun getExhibitList(type: String, scope: String): Result<ExhibitResult> {
        TODO("Not yet implemented")
    }

    override suspend fun getExhibit(type: String, scope: String, id: Int): Result<Exhibit> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlantList(
        type: String,
        scope: String,
        exhibit: String
    ): Result<List<Plant>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlant(type: String, scope: String, id: Int): Result<Plant> {
        TODO("Not yet implemented")
    }

}