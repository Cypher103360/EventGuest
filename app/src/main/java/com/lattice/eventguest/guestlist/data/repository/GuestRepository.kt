package com.lattice.eventguest.guestlist.data.repository

import com.lattice.eventguest.guestlist.data.model.Guest

interface GuestRepository {

    suspend fun addGuestToEvent(eventId: String, peopleIds: List<String>)
    suspend fun fetchGuestByEventId(eventId: String): List<Guest>
    suspend fun markGuestArrived(eventId: String, guestId: String)
}