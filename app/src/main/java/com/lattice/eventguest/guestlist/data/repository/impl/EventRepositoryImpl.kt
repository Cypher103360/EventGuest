package com.lattice.eventguest.guestlist.data.repository.impl

import com.lattice.eventguest.guestlist.data.model.Event
import com.lattice.eventguest.guestlist.data.remote.EventApiService
import com.lattice.eventguest.guestlist.data.repository.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(private val eventApiService: EventApiService): EventRepository {

    override suspend fun fetchEvents(): List<Event> {
        return if (eventApiService.getAllEvents().isSuccessful) {
            eventApiService.getAllEvents().body() ?: emptyList()
        } else {
            emptyList()
        }
    }

    override suspend fun addEvent(event: Event): Event {
        val response = eventApiService.addEvent(event)
        return if (response.isSuccessful) {
            println("Event added successfully: ${response.body()}")
            response.body() ?: event
        } else {
            throw Exception("Failed to add event: ${response.errorBody()?.string()}")
        }
    }
}