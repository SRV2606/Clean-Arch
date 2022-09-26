package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClosedPrs(
    var createdAt: String? = "",
    var title: String? = "",
    var closedAt: String? = "",
    var user: User? = null
) : Parcelable