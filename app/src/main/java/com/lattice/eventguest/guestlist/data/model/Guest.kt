package com.lattice.eventguest.guestlist.data.model

import androidx.annotation.Keep

@Keep
data class Guest(
    val address: String,
    val arrived: Boolean,
    val city: String,
    val email: String,
    val id: String,
    val mobile: String,
    val name: String,
    val state: String,
    val zip: Int
)