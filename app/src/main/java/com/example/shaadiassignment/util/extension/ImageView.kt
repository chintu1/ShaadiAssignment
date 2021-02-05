package com.example.shaadiassignment.util

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

fun ImageView.loadImage(context: Context, imageUrl: String , placeHolderColorId:Int) {
    Glide.with(context).load(imageUrl)
        .placeholder(ColorDrawable(ContextCompat.getColor(context, placeHolderColorId)))
        .into(this)
}