package com.chloetseng.zoo

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chloetseng.zoo.data.Exhibit
import com.chloetseng.zoo.home.HomeAdapter
import com.bumptech.glide.Glide
import com.chloetseng.zoo.data.Plant
import com.chloetseng.zoo.exhibit.ExhibitAdapter
import com.chloetseng.zoo.network.LoadApiStatus

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}


@BindingAdapter("exhibitItems")
fun bindRecyclerViewWithExhibitItems(recyclerView: RecyclerView, items: List<Exhibit>?) {
    items?.let {
        recyclerView.adapter?.apply {
            when (this) {
                is HomeAdapter -> submitList(it)
            }
        }
    }
}

@BindingAdapter("plantItems")
fun bindRecyclerViewWithPlantItems(recyclerView: RecyclerView, items: List<Plant>?) {
    items?.let {
        recyclerView.adapter?.apply {
            when (this) {
                is ExhibitAdapter -> submitList(it)
            }
        }
    }
}

@BindingAdapter("setupApiStatus")
fun bindApiStatus(view: ProgressBar, status: LoadApiStatus?) {
    when (status) {
        LoadApiStatus.LOADING -> view.visibility = View.VISIBLE
        LoadApiStatus.DONE, LoadApiStatus.ERROR -> view.visibility = View.GONE
    }
}

@BindingAdapter("setupApiErrorMessage")
fun bindApiErrorMessage(view: TextView, message: String?) {
    when (message) {
        null, "" -> {
            view.visibility = View.GONE
        }
        else -> {
            view.text = message
            view.visibility = View.VISIBLE
        }
    }
}