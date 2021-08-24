package com.chloetseng.zoo.exhibit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.data.Plant

class ExhibitViewModel(private val args: Int) : ViewModel() {

    private val _id = MutableLiveData<Int>().apply {
        value = args
    }
    val id: LiveData<Int>
        get() = _id

    private val _exhibit = MutableLiveData<Exhibit>()
    val exhibit: LiveData<Exhibit>
        get() = _exhibit

    private val _plant = MutableLiveData<List<Plant>>()
    val plant: LiveData<List<Plant>>
        get() = _plant

    private val _navToPlant = MutableLiveData<Int?>()
    val navToPlant: LiveData<Int?>
        get() = _navToPlant

    fun navToPlant(plant: Plant){
        _navToPlant.value = plant.id
    }
    fun onPlantNav(){
        _navToPlant.value = null
    }

    val mockId: Int = 0
    val name: String = "可愛動物區"
    val info: String = "教育中心包括博物館展示區、圖書館、演講廳、動物藝坊及動物學堂等，為本園展示動物園文化的櫥窗。館內以動物標本、生態全景展示傳達動物知識及保育觀念，最特別的是還有亞洲象「林旺」的標本展示區，以及恐龍模型展示喔！"
    val picture: String = "http://www.zoo.gov.tw/iTAP/05_Exhibit/09_EducationCenter.jpg"
    val category: String ="戶外區"
    val geo: String = "MULTIPOINT ((121.5888946 24.9957179))"
    val url: String = "http://www.zoo.gov.tw/introduce/gq.aspx?tid=19"
    val number: String = "0"
    val memo: String = "每週一休館，入館門票：全票20元、優待票10元"

    fun setExhibitData(){
        _exhibit.value = Exhibit(mockId,name, info, picture, category, geo, url, number, memo)
    }

    fun setPlantData(){
        val mockData: MutableList<Plant> = mutableListOf()
        mockData.add(Plant(mockId, name, info, picture, category, geo, url, number, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, picture, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo))
        mockData.add(Plant(mockId, name, info, picture, category, geo, url, number, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, picture, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo))
        mockData.add(Plant(mockId, name, info, picture, category, geo, url, number, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, picture, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo))
        mockData.add(Plant(mockId, name, info, picture, category, geo, url, number, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, picture, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo, memo))
        _plant.value = mockData
    }

}