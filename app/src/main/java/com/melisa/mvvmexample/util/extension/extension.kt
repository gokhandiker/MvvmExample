package com.melisa.mvvmexample.util.extension

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import android.net.ConnectivityManager
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import com.melisa.mvvmexample.R

fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}


fun View.invisible() { visibility = View.INVISIBLE }
fun View.visible() { visibility = View.VISIBLE }
fun View.gone() { visibility = View.GONE }

/**
 * Extension function on Snackbar
 */
fun View.showSnackBar(msgId: String) {
    val snackbar = Snackbar.make(
        this,
        msgId,
        Snackbar.LENGTH_LONG
    )
//    snackbar.setAction("Dismiss") { dismissSnackBar(snackbar) }
    snackbar.show()
}


fun Application.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


fun Application.isConnectedToInternet(): Boolean =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as
            ConnectivityManager).activeNetworkInfo?.isConnected == true






@BindingAdapter("android:src")
fun loadImage(imageView: ImageView, string_url: String) {
    Glide.with(imageView.context).load(string_url)
        .thumbnail(0.5f)
        .apply(RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.drawable.ic_launcher_foreground))
        .into(imageView)
}

fun ImageView.loadImage(uri:String?, progressDrawable: CircularProgressDrawable){

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}