package com.lattice.eventguest.guestlist.data.remote

import com.lattice.eventguest.guestlist.data.model.People
import retrofit2.Response
import retrofit2.http.GET

interface PeopleApiService {

    @GET("/people")
    suspend fun getAllPeople(): Response<List<People>>
}