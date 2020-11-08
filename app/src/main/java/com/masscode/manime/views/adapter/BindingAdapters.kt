package com.masscode.manime.views.adapter

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation

@BindingAdapter("showImageFromUrl")
fun showImageFromUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).into(imageView)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("type")
fun type(textView: TextView, type: String?) {
    textView.text = "Type: $type"
}

@BindingAdapter("showBlurImage")
fun showBlurImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url)
        .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3))).into(imageView)
}