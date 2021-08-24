package com.chloetseng.zoo.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chloetseng.zoo.exhibit.ExhibitViewModel

@Suppress("UNCHECKED_CAST")
class ExhibitViewModelFactory(private val exhibitKey: Int): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(ExhibitViewModel::class.java) -> ExhibitViewModel(exhibitKey)
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}