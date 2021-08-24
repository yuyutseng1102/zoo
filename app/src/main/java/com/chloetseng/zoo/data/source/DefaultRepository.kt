package com.chloetseng.zoo.data.source

import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.data.Result

class DefaultRepository(private val remoteDataSource: DataSource,
                        private val localDataSource: DataSource,): Repository {

    override suspend fun getExhibitList(type: String, scope: String): Result<List<Exhibit>> {
        return remoteDataSource.getExhibitList(type, scope)
    }

    override suspend fun getPlantList(type: String, scope: String): Result<List<Plant>> {
        return localDataSource.getPlantList(type, scope)
    }

}