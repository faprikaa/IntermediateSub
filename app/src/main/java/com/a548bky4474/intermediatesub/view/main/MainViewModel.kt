package com.a548bky4474.intermediatesub.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.data.response.StoryResponse
import com.a548bky4474.intermediatesub.repository.StoryRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: StoryRepository) : ViewModel() {

    lateinit var userModel: LiveData<UserModel>

    val _stories = MutableLiveData<StoryResponse>()
    var stories: LiveData<StoryResponse> = _stories
    var story: LiveData<PagingData<ListStoryItem>>? = null
    fun fetchStory() {
        viewModelScope.launch {
            repository.getSession().collect {
                story = repository.getStoriesPagingRepo(it.token)
            }
        }    }

    fun getSession(): LiveData<UserModel> {
        userModel = repository.getSession().asLiveData()
        return userModel
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun getStories() {
        viewModelScope.launch {
            repository.getSession().collect {
                _stories.value = repository.getStoriesRepo(it.token)
            }
        }
    }
    fun getStoriesWithLocation() {
        viewModelScope.launch {
            repository.getSession().collect {
                _stories.value = repository.getStoriesWithLocationRepo(it.token)
            }
        }
    }
}