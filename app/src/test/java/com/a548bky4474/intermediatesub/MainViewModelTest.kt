package com.a548bky4474.intermediatesub


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.AsyncPagingDataDiffer
import androidx.paging.PagingData
import org.junit.Assert
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import com.a548bky4474.intermediatesub.data.Result
import com.a548bky4474.intermediatesub.data.paging.StoryPagingSource
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.data.response.StoryResponse
import com.a548bky4474.intermediatesub.repository.StoryRepository
import com.a548bky4474.intermediatesub.view.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRules = MainDispatcherRule()

    @Mock
    private lateinit var storyRepository: StoryRepository
    private lateinit var mainViewModel: MainViewModel
    private val dummyStories = DataDummy.generateDummyStoryEntity()

    @Before
    fun setUp() {

        mainViewModel = MainViewModel(storyRepository)
        `when`(storyRepository.getSession()).thenReturn(flowOf(UserModel("dummy_email@mail.com", "dummy-token", true)))

    }

    @Test
    fun `when Get Story Should Not Null and Return Not Null`() =
        runTest {
            val expectedStories = MutableLiveData<StoryResponse> ()
            expectedStories.value = dummyStories
            `when`(storyRepository.getStoriesRepo("dummy-token")).thenReturn(dummyStories)

            mainViewModel.getStories()
            val actualStory = mainViewModel.stories

            Mockito.verify(storyRepository).getStoriesRepo("dummy-token")
            Assert.assertNotNull(actualStory)
        }


}