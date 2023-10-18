package com.a548bky4474.intermediatesub.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a548bky4474.intermediatesub.data.response.RegisterResponse
import com.a548bky4474.intermediatesub.repository.StoryRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val storyRepository: StoryRepository): ViewModel() {

    private val _resultRegister = MutableLiveData<RegisterResponse>()
    val resultRegister: LiveData<RegisterResponse> = _resultRegister

    fun registerUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            _resultRegister.value = storyRepository.registerUser(name, email, password)
        }
    }
}