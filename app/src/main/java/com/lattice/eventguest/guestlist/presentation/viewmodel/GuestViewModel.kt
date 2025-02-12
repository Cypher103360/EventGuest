package com.lattice.eventguest.guestlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lattice.eventguest.guestlist.data.model.Guest
import com.lattice.eventguest.guestlist.data.repository.GuestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuestViewModel @Inject constructor(private val guestRepository: GuestRepository): ViewModel() {

    val guestList = mutableListOf<Guest>()

    fun addGuestToEvent(eventId: String, peopleIds: List<String>) {
        viewModelScope.launch {
            guestRepository.addGuestToEvent(eventId, peopleIds)
        }
    }

    fun getGuestListByEventId(eventId: String) {
        viewModelScope.launch {
            guestList.addAll(guestRepository.fetchGuestByEventId(eventId = eventId))
        }
    }

    fun markGuestArrived(eventId: String, guestId: String) {
        viewModelScope.launch {
            guestRepository.markGuestArrived(eventId, guestId)
        }
    }
}