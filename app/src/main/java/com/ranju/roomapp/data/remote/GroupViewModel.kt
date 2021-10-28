package com.ranju.roomapp.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ranju.roomapp.data.local.GroupRepository
import com.ranju.roomapp.data.remote.model.Baseurl
import com.ranju.roomapp.data.remote.model.Group
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(
    private  val repository: GroupRepository
): ViewModel() {
    init {
        viewModelScope.launch {
            val userId = "756"
            repository.fetchGroups(userId,"2")
        }
    }
    val allGroups: LiveData<List<Group>> = repository.getAllGroups()
    val allUrls = repository.getAllUrls()
}