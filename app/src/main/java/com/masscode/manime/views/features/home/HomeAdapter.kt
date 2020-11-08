package com.masscode.manime.views.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.masscode.manime.R
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.masscode.manime.databinding.ItemAnimeListBinding

class HomeAdapter(private val showDetail: (id: Int) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.AnimeViewHolder>() {

    private var listData = ArrayList<AnimeListResponse>()
    private val limit: Int = 10

    fun setData(newListData: List<AnimeListResponse>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeAdapter.AnimeViewHolder {
        val view: ItemAnimeListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_anime_list,
            parent,
            false
        )
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.AnimeViewHolder, position: Int) {
        val item = listData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return if (listData.size > limit)
            limit
        else
            listData.size
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeListResponse: AnimeListResponse) {
            binding.anime = animeListResponse
            binding.executePendingBindings()
            binding.root.setOnClickListener { animeListResponse.id?.let { it1 -> showDetail(it1) } }
        }
    }
}