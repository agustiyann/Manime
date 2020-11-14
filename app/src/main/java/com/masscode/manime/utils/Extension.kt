package com.masscode.manime.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Context.appToast(msg: CharSequence, isShort: Boolean = true) {
    if (!isShort) Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    else Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.appToast(msg: CharSequence, isShort: Boolean = true) {
    if (!isShort) Toast.makeText(this as Context, msg, Toast.LENGTH_LONG).show()
    else Toast.makeText(this as Context, msg, Toast.LENGTH_SHORT).show()
}

fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.inVisible(){
    this.visibility = View.INVISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}