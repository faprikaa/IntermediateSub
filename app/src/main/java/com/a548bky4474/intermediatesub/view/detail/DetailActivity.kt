package com.a548bky4474.intermediatesub.view.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.databinding.ActivityDetailBinding
import com.a548bky4474.intermediatesub.view.StoryAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class DetailActivity : AppCompatActivity() {
    private lateinit var detailStory: ListStoryItem
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            detailStory = intent.getParcelableExtra(StoryAdapter.PARCEL_NAME, ListStoryItem::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            detailStory = intent.getParcelableExtra(StoryAdapter.PARCEL_NAME)!!
        }

        Glide.with(binding.root)
            .load(detailStory.photoUrl)
            .into(binding.ivStoryDt)
        binding.tvNamaDt.text = detailStory.name
        binding.tvDeskripsiDt.text = detailStory.description
        binding.tvCreatedAt.text = dateFormatter(detailStory.createdAt)
    }

    private fun dateFormatter(date: String?): String? {
        val inputDate = "2023-10-19T06:13:25.648Z"

        val instant = Instant.parse(inputDate)
        val zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Jakarta"))

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
        val outputDate = formatter.format(zonedDateTime)
        return outputDate
    }
}