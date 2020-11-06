package com.masscode.manime.views.season

import androidx.recyclerview.widget.DiffUtil
import com.masscode.manime.data.source.remote.response.AnimeListResponse

class SeasonDiffUtil(
    private val oldList: List<AnimeListResponse>,
    private val newList: List<AnimeListResponse>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}