package com.masscode.manime.utils

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("showImageFromUrl")
fun showImageFromUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("type")
fun type(textView: TextView, type: String) {
    textView.text = "Type: $type"
}