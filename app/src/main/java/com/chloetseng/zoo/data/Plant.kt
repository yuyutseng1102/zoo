package com.chloetseng.zoo.data

import android.os.Parcelable
import android.text.TextUtils.replace
import android.util.Log
import com.google.android.play.core.internal.l
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.lang.System.out
import java.net.URLDecoder

@Parcelize
data class Plant(
    @Json(name = "_id") val id: Int,
    @Json(name = "F_Name_En") val nameEn: String,
    @Json(name = "\uFEFFF_Name_Ch") val nameCh: String,
    @Json(name = "F_Name_Latin") val nameLatin: String,
    @Json(name = "F_Location") val location: String,
    @Json(name = "F_Summary") val summary: String,
    @Json(name = "F_Keywords") val keyWords: String,
    @Json(name = "F_Code") val code: String,
    @Json(name = "F_Geo") val geo: String,
    @Json(name = "F_AlsoKnown") val alsoKnown: String,
    @Json(name = "F_Brief") val brief: String,
    @Json(name = "F_Feature") val feature: String,
    @Json(name = "F_Family") val family: String,
    @Json(name = "F_CID") val cid: String,
    @Json(name = "F_Genus") val genus: String,
    @Json(name = "F_Function＆Application") val function: String,
    @Json(name = "F_Update") val update: String,
    @Json(name = "F_Pic01_ALT") val pic01Alt: String,
    @Json(name = "F_Pic02_ALT") val pic02Alt: String,
    @Json(name = "F_Pic03_ALT") val pic03Alt: String,
    @Json(name = "F_Pic04_ALT") val pic04Alt: String,
    @Json(name = "F_Pic01_URL") val pic01Url: String,
    @Json(name = "F_Pic02_URL") val pic02Url: String,
    @Json(name = "F_Pic03_URL") val pic03Url: String,
    @Json(name = "F_Pic04_URL") val pic04Url: String,
    @Json(name = "F_pdf01_ALT") val pdf01Alt: String,
    @Json(name = "F_pdf02_ALT") val pdf02Alt: String,
    @Json(name = "F_pdf01_URL") val pdf01Url: String,
    @Json(name = "F_pdf02_URL") val pdf02Url: String,
    @Json(name = "F_Vedio_URL") val vedioUrl: String,
    @Json(name = "F_Voice01_ALT") val voice01Alt: String,
    @Json(name = "F_Voice02_ALT") val voice02Alt: String,
    @Json(name = "F_Voice03_ALT") val voice03Alt: String,
    @Json(name = "F_Voice01_URL") val voice01Url: String,
    @Json(name = "F_Voice02_URL") val voice02Url: String,
    @Json(name = "F_Voice03_URL") val voice03Url: String,
): Parcelable