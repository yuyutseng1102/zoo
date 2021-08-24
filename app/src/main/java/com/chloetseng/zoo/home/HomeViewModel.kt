package com.chloetseng.zoo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chloetseng.zoo.data.Exhibit

class HomeViewModel: ViewModel() {

    private val _exhibit = MutableLiveData<List<Exhibit>>()
    val exhibit: LiveData<List<Exhibit>>
    get() = _exhibit

    private val _navToExhibit = MutableLiveData<Int?>()
    val navToExhibit: LiveData<Int?>
        get() = _navToExhibit

    fun navToExhibit(exhibit: Exhibit){
        _navToExhibit.value = exhibit.id
    }

    fun onExhibitNav(){
        _navToExhibit.value = null
    }

    val id: Int = 0
    val name: String = "可愛動物區"
    val info: String = "教育中心包括博物館展示區、圖書館、演講廳、動物藝坊及動物學堂等，為本園展示動物園文化的櫥窗。館內以動物標本、生態全景展示傳達動物知識及保育觀念，最特別的是還有亞洲象「林旺」的標本展示區，以及恐龍模型展示喔！"
    val picture: String = "http://www.zoo.gov.tw/iTAP/05_Exhibit/09_EducationCenter.jpg"
    val category: String ="戶外區"
    val geo: String = "MULTIPOINT ((121.5888946 24.9957179))"
    val url: String = "http://www.zoo.gov.tw/introduce/gq.aspx?tid=19"
    val number: String = "0"
    val memo: String = "每週一休館，入館門票：全票20元、優待票10元"

    fun setData(){
        val mockData: MutableList<Exhibit> = mutableListOf()
        mockData.add(Exhibit(id, name, info, picture, category, geo, url, number, memo))
        mockData.add(Exhibit(id+1, name, info, picture, category, geo, url, number, memo))
        mockData.add(Exhibit(id+2, name, info, picture, category, geo, url, number, memo))
        mockData.add(Exhibit(id+3, name, info, picture, category, geo, url, number, memo))
        mockData.add(Exhibit(id+4, name, info, picture, category, geo, url, number, memo))
        mockData.add(Exhibit(id+5, name, info, picture, category, geo, url, number, memo))
        mockData.add(Exhibit(id+6, name, info, picture, category, geo, url, number, memo))

        _exhibit.value = mockData
    }
}