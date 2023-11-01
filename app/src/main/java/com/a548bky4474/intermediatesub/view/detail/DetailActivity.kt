package com.a548bky4474.intermediatesub.view.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a548bky4474.intermediatesub.R
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.databinding.ActivityDetailBinding
import com.a548bky4474.intermediatesub.view.StoryAdapter
import com.a548bky4474.intermediatesub.view.dateFormatter
import com.bumptech.glide.Glide

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
        binding.tvLong.text = getString(R.string.longtitude, detailStory.lon.toString().slice(1..7))
        binding.tvLat.text = getString(R.string.latitude, detailStory.lat.toString().slice(1..7))
        binding.tvDeskripsiDt.text = detailStory.description
        binding.tvCreatedAt.text = dateFormatter(detailStory.createdAt)
    }

}