package com.lattice.eventguest.guestlist.data.remote

import com.lattice.eventguest.guestlist.data.model.Event
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EventApiService {

    @POST("/event")
    suspend fun addEvent(@Body event: Event): Response<Event>

    @GET("/event")
    suspend fun getAllEvents(): Response<List<Event>>
}