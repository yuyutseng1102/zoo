package com.chloetseng.zoo.data.source

import com.chloetseng.zoo.data.*

interface DataSource {

    suspend fun getExhibitList(type:String, scope: String): Result<ExhibitResult>
    suspend fun getPlantList(type:String, scope: String): Result<PlantResult>
}