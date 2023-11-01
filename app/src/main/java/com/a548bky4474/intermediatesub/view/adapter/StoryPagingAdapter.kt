package com.a548bky4474.intermediatesub.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.databinding.ItemStoryBinding
import com.a548bky4474.intermediatesub.view.detail.DetailActivity
import com.bumptech.glide.Glide

class StoryPagingAdapter :
    PagingDataAdapter<ListStoryItem, StoryPagingAdapter.MyViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    class MyViewHolder(private val binding: ItemStoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListStoryItem) {
            binding.tvNama.text = item.name
            binding.tvDeskripsi.text = item.description
            Glide.with(binding.root)
                .load(item.photoUrl)
                .into(binding.ivStory)
            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(PARCEL_NAME, item)
                val optionsCompat: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity,
                        Pair(binding.ivStory, "photo"),
                        Pair(binding.tvNama, "name"),
                        Pair(binding.tvDeskripsi, "desc"),
                    )
                itemView.context.startActivity(intent, optionsCompat.toBundle())
            }
        }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListStoryItem>() {
            override fun areItemsTheSame(oldItem: ListStoryItem, newItem: ListStoryItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListStoryItem, newItem: ListStoryItem): Boolean {
                return oldItem == newItem
            }
        }
        const val PARCEL_NAME = "data"
    }
}