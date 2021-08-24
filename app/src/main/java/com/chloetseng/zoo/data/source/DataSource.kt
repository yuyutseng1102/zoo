package com.chloetseng.zoo.data.source

import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.data.Result

interface DataSource {

    suspend fun getExhibitList(type:String, scope: String): Result<List<Exhibit>>
    suspend fun getPlantList(type:String, scope: String): Result<List<Plant>>
}