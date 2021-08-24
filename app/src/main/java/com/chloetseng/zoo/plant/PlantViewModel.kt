package com.chloetseng.zoo.plant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.data.source.Repository

class PlantViewModel(private val repository: Repository, private val args: Int) : ViewModel() {
    private val _id = MutableLiveData<Int>().apply {
        value = args
    }
    val id: LiveData<Int>
        get() = _id

    private val _plant = MutableLiveData<List<Plant>>()
    val plant: LiveData<List<Plant>>
        get() = _plant
}