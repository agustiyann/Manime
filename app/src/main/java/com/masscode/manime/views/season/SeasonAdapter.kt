package com.masscode.manime.views.season

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.masscode.manime.R
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.masscode.manime.databinding.ItemAnimeMoreBinding

class SeasonAdapter : RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {

    private var listData = emptyList<AnimeListResponse>()

    fun setData(newListData: List<AnimeListResponse>) {
        val seasonDiffUtil = SeasonDiffUtil(listData, newListData)
        val seasonDiffResult = DiffUtil.calculateDiff(seasonDiffUtil)
        this.listData = newListData
        seasonDiffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SeasonAdapter.SeasonViewHolder {
        val view: ItemAnimeMoreBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_anime_more,
            parent,
            false
        )
        return SeasonViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeasonAdapter.SeasonViewHolder, position: Int) {
        val item = listData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listData.size

    inner class SeasonViewHolder(private val binding: ItemAnimeMoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: AnimeListResponse) {
            binding.anime = anime
            binding.executePendingBindings()
        }
    }
}