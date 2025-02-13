package com.lattice.eventguest.guestlist.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Format Timestamp to Readable Date-Time
fun formatTimestamp(timestamp: Long): String {
    val sdf = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
    return sdf.format(Date(timestamp))
}