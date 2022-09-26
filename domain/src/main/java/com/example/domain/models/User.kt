package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id: Int? = 0,
    var login: String? = "",
    var nodeId: String? = "",
    var organizationsUrl: String? = "",
    var avatarUrl: String? = "",
    var receivedEventsUrl: String? = "",
) : Parcelable