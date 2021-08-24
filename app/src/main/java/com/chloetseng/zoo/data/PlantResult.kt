package com.chloetseng.zoo.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlantResult(
    val result: PlantData
): Parcelable