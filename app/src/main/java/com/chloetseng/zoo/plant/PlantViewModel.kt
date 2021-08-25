package com.chloetseng.zoo.plant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.data.Result
import com.chloetseng.zoo.data.source.Repository
import com.chloetseng.zoo.network.LoadApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PlantViewModel(private val repository: Repository, private val args: Int) : ViewModel() {
    private val _id = MutableLiveData<Int>().apply {
        value = args
    }
    val id: LiveData<Int>
        get() = _id

    private val _plant = MutableLiveData<Plant>()
    val plant: LiveData<Plant>
        get() = _plant

    private val _status = MutableLiveData<LoadApiStatus>()
    val status: LiveData<LoadApiStatus>
        get() = _status


    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    val PLANT_TYPE = "f18de02f-b6c9-47c0-8cda-50efad621c14"
    val SCOPE = "resourceAquire"

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        getExhibit(type = PLANT_TYPE, scope = SCOPE, id = _id.value ?: 0)
    }

    private fun getExhibit(type: String, scope: String, id: Int) {
        coroutineScope.launch {
            val result = repository.getPlant(type, scope, id)
            _plant.value = when (result) {
                is Result.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    result.data
                }
                is Result.Fail -> {
                    _error.value = result.error
                    _status.value = LoadApiStatus.ERROR
                    null
                }
                is Result.Error -> {
                    _error.value = result.exception.toString()
                    _status.value = LoadApiStatus.ERROR
                    null
                }
                else -> {
                    _error.value = "Error"
                    _status.value = LoadApiStatus.ERROR
                    null
                }
            }
        }
    }
}