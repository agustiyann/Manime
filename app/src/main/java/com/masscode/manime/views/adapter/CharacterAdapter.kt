package com.masscode.manime.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.masscode.manime.R
import com.masscode.manime.data.source.remote.response.CharactersListResponse
import com.masscode.manime.databinding.ItemCharactersListBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var listData = ArrayList<CharactersListResponse>()
    private val limit: Int = 20

    fun setData(newListData: List<CharactersListResponse>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view: ItemCharactersListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_characters_list,
            parent,
            false
        )
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = listData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return if (listData.size > limit)
            limit
        else
            listData.size
    }

    class CharacterViewHolder(private val binding: ItemCharactersListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharactersListResponse) {
            binding.character = character
            binding.executePendingBindings()
        }
    }
}