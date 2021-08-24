package com.chloetseng.zoo.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chloetseng.zoo.data.source.Repository
import com.chloetseng.zoo.exhibit.ExhibitViewModel
import com.chloetseng.zoo.plant.PlantViewModel

@Suppress("UNCHECKED_CAST")
class ExhibitViewModelFactory(private val repository: Repository, private val idKey: Int): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(ExhibitViewModel::class.java) -> ExhibitViewModel(repository, idKey)
                isAssignableFrom(PlantViewModel::class.java) -> PlantViewModel(repository, idKey)
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}