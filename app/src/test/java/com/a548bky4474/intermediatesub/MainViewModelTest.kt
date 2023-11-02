package com.a548bky4474.intermediatesub


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.AsyncPagingDataDiffer
import androidx.paging.PagingData
import androidx.recyclerview.widget.ListUpdateCallback
import com.a548bky4474.intermediatesub.LiveDataTestUtil.getOrAwaitValue
import org.junit.Assert
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import com.a548bky4474.intermediatesub.data.Result
import com.a548bky4474.intermediatesub.data.paging.StoryPagingSource
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.data.response.StoryResponse
import com.a548bky4474.intermediatesub.repository.StoryRepository
import com.a548bky4474.intermediatesub.view.adapter.StoryPagingAdapter
import com.a548bky4474.intermediatesub.view.main.MainViewModel
import junit.framework.TestCase.assertEquals
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
            var actualSize = 0
            var actualStoryFirstItem: ListStoryItem? = null

            val observer = Observer<StoryResponse> { storyResponse ->
                // The size of the response can be determined here
                actualSize = storyResponse?.listStory?.size ?: 0
                actualStoryFirstItem = storyResponse.listStory[0]
            }

            actualStory.observeForever(observer)

            Mockito.verify(storyRepository).getStoriesRepo("dummy-token")
            Assert.assertNotNull(actualStory)
            assertEquals(dummyStories.listStory.size, actualSize)
            assertEquals(dummyStories.listStory[0], actualStoryFirstItem)

            actualStory.removeObserver(observer)
        }

    @Test
    fun `when Get Story Empty Should Return No Data`() = runTest {
        val data: PagingData<ListStoryItem> = PagingData.from(emptyList())
        val expectedStory = MutableLiveData<PagingData<ListStoryItem>>()
        expectedStory.value = data
        `when`(storyRepository.getStoriesPagingRepo("dummy-token")).thenReturn(expectedStory)
        val mainViewModel = MainViewModel(storyRepository)
        mainViewModel.fetchStory()
        val actualStory: PagingData<ListStoryItem>? = mainViewModel.story?.getOrAwaitValue()
        val differ = AsyncPagingDataDiffer(
            diffCallback = StoryPagingAdapter.DIFF_CALLBACK,
            updateCallback = noopListUpdateCallback,
            workerDispatcher = Dispatchers.Main,
        )
        differ.submitData(actualStory!!)

        Assert.assertEquals(0, differ.snapshot().size)
    }

    val noopListUpdateCallback = object : ListUpdateCallback {
        override fun onInserted(position: Int, count: Int) {}
        override fun onRemoved(position: Int, count: Int) {}
        override fun onMoved(fromPosition: Int, toPosition: Int) {}
        override fun onChanged(position: Int, count: Int, payload: Any?) {}
    }
}