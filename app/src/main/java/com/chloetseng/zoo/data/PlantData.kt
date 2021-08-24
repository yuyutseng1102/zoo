package com.chloetseng.zoo.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlantData(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<Plant>
): Parcelable