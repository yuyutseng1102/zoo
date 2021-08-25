package com.chloetseng.zoo

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun isInternetConnected(): Boolean {
    val cm = ZooApplication.instance
        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}

fun getString(resourceId: Int): String {
    return ZooApplication.instance.getString(resourceId)
}

val SCOPE = "resourceAquire"