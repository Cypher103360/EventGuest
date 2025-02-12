package com.lattice.eventguest.guestlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lattice.eventguest.guestlist.data.repository.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(private val peopleRepository: PeopleRepository): ViewModel() {

    init {
        viewModelScope.launch {
            peopleRepository.fetchAllPeople()
        }
    }
}