package com.example.fragmentexample

import android.content.res.Resources
import android.util.DisplayMetrics

object Utils {

    val Int.dp: Int
        get() = (this / Resources.getSystem().displayMetrics.density).toInt()
    val Int.px: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()
}