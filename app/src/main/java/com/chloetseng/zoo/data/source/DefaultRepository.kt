package com.chloetseng.zoo.data.source

import com.chloetseng.zoo.data.*

class DefaultRepository(private val remoteDataSource: DataSource,
                        private val localDataSource: DataSource,): Repository {

    override suspend fun getExhibitList(type: String, scope: String): Result<ExhibitResult> {
        return remoteDataSource.getExhibitList(type, scope)
    }

    override suspend fun getExhibit(type: String, scope: String, id: Int): Result<Exhibit> {
        return remoteDataSource.getExhibit(type, scope, id)
    }

    override suspend fun getPlantList(type: String, scope: String): Result<PlantResult> {
        return localDataSource.getPlantList(type, scope)
    }

}