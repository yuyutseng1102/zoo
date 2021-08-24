package com.chloetseng.zoo.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chloetseng.zoo.home.HomeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel()

                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}