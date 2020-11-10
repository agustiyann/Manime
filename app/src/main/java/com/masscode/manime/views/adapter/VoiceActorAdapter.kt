package com.masscode.manime.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.masscode.manime.R
import com.masscode.manime.data.source.remote.response.detail.VoiceActors
import com.masscode.manime.databinding.ItemVoiceActorBinding

class VoiceActorAdapter : RecyclerView.Adapter<VoiceActorAdapter.ActorViewHolder>() {

    private var listData = ArrayList<VoiceActors>()

    fun setData(newListData: List<VoiceActors>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorViewHolder {
        val view: ItemVoiceActorBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_voice_actor,
            parent,
            false
        )
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val item = listData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listData.size

    class ActorViewHolder(private val binding: ItemVoiceActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: VoiceActors) {
            binding.actor = actor
            binding.executePendingBindings()
        }
    }
}