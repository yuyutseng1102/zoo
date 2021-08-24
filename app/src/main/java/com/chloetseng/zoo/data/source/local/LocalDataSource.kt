package com.chloetseng.zoo.data.source.local

import android.content.Context
import com.chloetseng.zoo.data.*
import com.chloetseng.zoo.data.source.DataSource

class LocalDataSource(context: Context) : DataSource {
    override suspend fun getExhibitList(type: String, scope: String): Result<ExhibitResult> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlantList(type: String, scope: String): Result<PlantResult> {
        TODO("Not yet implemented")
    }
}