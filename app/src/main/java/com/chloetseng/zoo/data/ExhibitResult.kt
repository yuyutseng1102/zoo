package com.chloetseng.zoo.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExhibitResult(
    val result: ExhibitData
): Parcelable

