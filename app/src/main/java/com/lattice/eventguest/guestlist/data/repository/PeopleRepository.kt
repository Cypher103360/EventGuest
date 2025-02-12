package com.lattice.eventguest.guestlist.data.repository

import com.lattice.eventguest.guestlist.data.model.People

interface PeopleRepository {

    suspend fun fetchAllPeople(): List<People>
}