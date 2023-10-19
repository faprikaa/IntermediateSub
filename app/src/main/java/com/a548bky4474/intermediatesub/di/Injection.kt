package com.a548bky4474.intermediatesub.di

import android.content.Context
import com.a548bky4474.intermediatesub.data.pref.UserPreference
import com.a548bky4474.intermediatesub.data.pref.dataStore
import com.a548bky4474.intermediatesub.repository.StoryRepository

object Injection {
    fun provideRepository(context: Context): StoryRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return StoryRepository.getInstance(pref)
    }

}