package com.a548bky4474.intermediatesub.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.data.response.StoryResponse
import com.a548bky4474.intermediatesub.repository.StoryRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val repository: StoryRepository) : ViewModel() {

    lateinit var userModel: LiveData<UserModel>

    private val _stories = MutableLiveData<StoryResponse>()
    val stories: LiveData<StoryResponse> = _stories

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


}