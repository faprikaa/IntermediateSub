package com.a548bky4474.intermediatesub

import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.data.response.StoryResponse

object DataDummy {
    fun generateDummyStoryEntity():StoryResponse {
        val storyList = ArrayList<ListStoryItem>()
        for (i in 0..10) {

            val story = ListStoryItem(
                "https://picsum.photos/1600/900",
                "2023-11-02T05:25:55.227Z",
                "Muammar Mufid yang ke ${i}",
                "a548bky4474 unit test, story ke ${i}",
                null,
                "story-ke-${i}",
                null
            )
            storyList.add(story)
        }
        var storyResponse = StoryResponse(
            storyList,
            false,
            "Story fetched successfully"
        )
        return storyResponse
    }
}