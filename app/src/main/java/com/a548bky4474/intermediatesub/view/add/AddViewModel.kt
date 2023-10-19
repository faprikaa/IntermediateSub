package com.a548bky4474.intermediatesub.view.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a548bky4474.intermediatesub.data.response.RegisterResponse
import com.a548bky4474.intermediatesub.repository.StoryRepository
import kotlinx.coroutines.launch
import java.io.File

class AddViewModel (private val storyRepository: StoryRepository): ViewModel() {

    private val _resultUpload = MutableLiveData<RegisterResponse>()
    val resultUpload: LiveData<RegisterResponse> = _resultUpload
    fun uploadImage(file: File, description: String) {
        viewModelScope.launch {
            storyRepository.getSession().collect {
                _resultUpload.value = storyRepository.uploadImage(file, description, it.token)
            }
        }

    }


}