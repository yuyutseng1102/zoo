package com.chloetseng.zoo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chloetseng.zoo.DataType
import com.chloetseng.zoo.R
import com.chloetseng.zoo.SCOPE
import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.data.source.Repository
import com.chloetseng.zoo.network.LoadApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import com.chloetseng.zoo.data.Result
import com.chloetseng.zoo.getString

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _exhibit = MutableLiveData<List<Exhibit>>()
    val exhibit: LiveData<List<Exhibit>>
        get() = _exhibit

    private val _navToExhibit = MutableLiveData<Int?>()
    val navToExhibit: LiveData<Int?>
        get() = _navToExhibit

    fun navToExhibit(exhibit: Exhibit) {
        _navToExhibit.value = exhibit.id
    }

    fun onExhibitNav() {
        _navToExhibit.value = null
    }

    private val _status = MutableLiveData<LoadApiStatus>()
    val status: LiveData<LoadApiStatus>
        get() = _status


    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        getExhibitList(type = DataType.EXHIBIT_TYPE.value, scope = SCOPE)
    }

    private fun getExhibitList(type: String, scope: String) {

        coroutineScope.launch {
            val result = repository.getExhibitList(type, scope)
            _exhibit.value = when (result) {
                is Result.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    result.data.result.results
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
                    _error.value = getString(R.string.error)
                    _status.value = LoadApiStatus.ERROR
                    null
                }
            }
        }
    }
}