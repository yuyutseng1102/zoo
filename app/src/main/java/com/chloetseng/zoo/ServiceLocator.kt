package com.chloetseng.zoo

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.chloetseng.zoo.data.source.DataSource
import com.chloetseng.zoo.data.source.DefaultRepository
import com.chloetseng.zoo.data.source.Repository
import com.chloetseng.zoo.data.source.local.LocalDataSource
import com.chloetseng.zoo.data.source.remote.RemoteDataSource

object ServiceLocator {

    @Volatile
    var repository: Repository? = null
        @VisibleForTesting set

    fun provideTasksRepository(context: Context): Repository {
        synchronized(this) {
            return repository
                ?: createRepository(context)
        }
    }

    private fun createRepository(context: Context): Repository {
        return DefaultRepository(
            RemoteDataSource,
            createLocalDataSource(context)
        )
    }

    private fun createLocalDataSource(context: Context): DataSource {
        return LocalDataSource(context)
    }
}