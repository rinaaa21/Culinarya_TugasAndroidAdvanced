package com.example.culinarya

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Resep(
    var imageResep: Int,
    var titleResep: String,
    var descResep: String,
    var detResep: String
) : Parcelable

