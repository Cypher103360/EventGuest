package com.lattice.eventguest.guestlist.data.repository

interface EventRepository {
    suspend fun fetchEvents()
}