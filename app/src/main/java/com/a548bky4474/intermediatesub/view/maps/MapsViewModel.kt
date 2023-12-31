package com.a548bky4474.intermediatesub.view.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.data.response.StoryResponse
import com.a548bky4474.intermediatesub.repository.StoryRepository
import kotlinx.coroutines.launch

class MapsViewModel(private val repository: StoryRepository) : ViewModel() {

    lateinit var userModel: LiveData<UserModel>

    private val _stories = MutableLiveData<StoryResponse>()
    val stories: LiveData<StoryResponse> = _stories

    fun getStoriesWithLocation() {
        viewModelScope.launch {
            repository.getSession().collect {
                _stories.value = repository.getStoriesWithLocationRepo(it.token)
            }
        }
    }
}