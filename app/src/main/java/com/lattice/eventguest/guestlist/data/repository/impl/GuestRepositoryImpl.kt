package com.lattice.eventguest.guestlist.data.repository.impl

import com.lattice.eventguest.guestlist.data.model.Guest
import com.lattice.eventguest.guestlist.data.remote.GuestApiService
import com.lattice.eventguest.guestlist.data.repository.GuestRepository
import javax.inject.Inject

class GuestRepositoryImpl @Inject constructor(private val guestApiService: GuestApiService): GuestRepository {
    override suspend fun addGuestToEvent(
        eventId: String,
        peopleIds: List<String>
    ) {
        guestApiService.addGuestToEvent(eventId, peopleIds)
    }

    override suspend fun fetchGuestByEventId(eventId: String): List<Guest> {
       return guestApiService.getGuestByEventId(eventId).body() ?: emptyList()
    }

    override suspend fun markGuestArrived(eventId: String, guestId: String) {
        guestApiService.markGuestArrived(eventId, guestId)
    }
}