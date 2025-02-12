package com.lattice.eventguest.guestlist.data.remote

import com.lattice.eventguest.guestlist.data.model.Guest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface GuestApiService {

    @POST("/guest/{event-id}")
    suspend fun addGuestToEvent(@Path("event-id") eventId: String, @Body peopleIdList: List<String>): Response<Void>

    @GET("/guest")
    suspend fun getGuestByEventId(@Query("eventId") eventId: String): Response<List<Guest>>

    @PUT("/guest")
    suspend fun markGuestArrived(@Query("eventId") eventId: String,  @Query("guestId") guestId: String): Response<Void>
}