package com.lattice.eventguest.guestlist.data.repository

import com.lattice.eventguest.guestlist.data.model.Event

interface EventRepository {
    suspend fun fetchEvents(): List<Event>
}