package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClosedPullRequests(
    var createdAt: String? = "",
    var title: String? = "",
    var user: User? = null
) : Parcelable