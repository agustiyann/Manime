package com.masscode.manime.views.more

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.masscode.manime.R
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.masscode.manime.databinding.ItemAnimeMoreBinding

class MoreAdapter(private val showDetail: (id: Int) -> Unit) : RecyclerView.Adapter<MoreAdapter.MoreViewHolder>() {

    private var listData = ArrayList<AnimeListResponse>()

    fun setData(newListData: List<AnimeListResponse>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreViewHolder {
        val view: ItemAnimeMoreBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_anime_more,
            parent,
            false
        )
        return MoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoreViewHolder, position: Int) {
        val item = listData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listData.size

    inner class MoreViewHolder(private val binding: ItemAnimeMoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: AnimeListResponse) {
            binding.anime = anime
            binding.executePendingBindings()
            binding.root.setOnClickListener { anime.id?.let { it1 -> showDetail(it1) } }
        }
    }
}