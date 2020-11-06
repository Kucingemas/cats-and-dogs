package com.example.catsanddogs.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cat(
    val imageUrl: String
) : Parcelable