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

    override suspend fun getPlantList(type: String, scope: String, exhibit: String): Result<List<Plant>> {
        return remoteDataSource.getPlantList(type, scope,exhibit)
    }

    override suspend fun getPlant(type: String, scope: String, id: Int): Result<Plant> {
        return remoteDataSource.getPlant(type, scope, id)
    }

}