package com.masscode.manime.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.masscode.manime.R
import com.masscode.manime.data.source.remote.response.detail.Promo
import com.masscode.manime.databinding.ItemVideosListBinding

class VideoAdapter(private val showVideo: (url: String?) -> Unit) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    private var listData = ArrayList<Promo>()

    fun setData(newListData: List<Promo>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view: ItemVideosListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_videos_list,
            parent,
            false
        )
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    inner class VideoViewHolder(private val binding: ItemVideosListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mPromo: Promo) {
            with(binding) {
                promo = mPromo
                executePendingBindings()
                root.setOnClickListener { showVideo(mPromo.videoUrl) }
            }
        }
    }
}