package com.lattice.eventguest.guestlist.data.repository

import com.lattice.eventguest.guestlist.data.Guest
import com.lattice.eventguest.guestlist.data.remote.GuestApiService
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val apiService: GuestApiService
): EventRepository {
    override suspend fun fetchEvents(

    ) {

    }
}