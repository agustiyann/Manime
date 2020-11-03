package com.masscode.manime.views.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.response.DetailAnimeResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class DetailAnimeViewModel(private val repository: Repository) : ViewModel() {

    private var id by Delegates.notNull<Int>()

    fun setDetailAnime(id: Int) {
        this.id = id
    }

    private var _anime = MutableLiveData<DetailAnimeResponse>()
    val anime: LiveData<DetailAnimeResponse>
        get() = _anime

    private val vmJob = Job()
    private val coroutineScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        try {
            coroutineScope.launch {
                val detailAnime = repository.getDetailAnime(id)
                _anime.value = detailAnime
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}