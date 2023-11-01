package com.a548bky4474.intermediatesub.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.data.response.LoginResponse
import com.a548bky4474.intermediatesub.repository.StoryRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: StoryRepository) : ViewModel() {

    private val _resultLogin = MutableLiveData<LoginResponse>()
    val resultLogin: LiveData<LoginResponse> = _resultLogin

    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }

    fun loginUser(email: String, password: String){
        viewModelScope.launch {
            _resultLogin.value = repository.loginUser(email, password)
        }
    }
}