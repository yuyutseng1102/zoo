package com.chloetseng.zoo

import android.app.Application
import com.chloetseng.zoo.data.source.Repository
import kotlin.properties.Delegates

class ZooApplication: Application() {

    val repository: Repository
        get() = ServiceLocator.provideTasksRepository(this)

    companion object {
        var instance: ZooApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}