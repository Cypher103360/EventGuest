package com.lattice.eventguest.guestlist.data.model

import androidx.annotation.Keep

@Keep
data class Event(
    val description: String,
    val endTimeStamp: Long,
    val id: String,
    val location: String,
    val startTimeStamp: Long,
    val title: String,
    val venue: String
)