package com.chloetseng.zoo.exhibit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.data.Plant

class ExhibitViewModel(private val args: String) : ViewModel() {

    private val _id = MutableLiveData<String>().apply {
        value = args
    }
    val id: LiveData<String>
        get() = _id

    private val _exhibit = MutableLiveData<Exhibit>()
    val exhibit: LiveData<Exhibit>
        get() = _exhibit

    private val _plant = MutableLiveData<List<Plant>>()
    val plant: LiveData<List<Plant>>
        get() = _plant



}