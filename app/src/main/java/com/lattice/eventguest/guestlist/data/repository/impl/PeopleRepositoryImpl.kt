package com.lattice.eventguest.guestlist.data.repository.impl

import com.lattice.eventguest.guestlist.data.model.People
import com.lattice.eventguest.guestlist.data.remote.PeopleApiService
import com.lattice.eventguest.guestlist.data.repository.PeopleRepository
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(private val peopleApiService: PeopleApiService): PeopleRepository {

    override suspend fun fetchAllPeople(): List<People> {
        return peopleApiService.getAllPeople().body() ?: emptyList()
    }
}