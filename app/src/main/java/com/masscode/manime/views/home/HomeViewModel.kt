package com.masscode.manime.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val vmJob = Job()
    private val coroutineScope = CoroutineScope(vmJob + Dispatchers.Main)

    private var _animeAiring = MutableLiveData<List<AnimeListResponse>>()
    val animeAiring: LiveData<List<AnimeListResponse>>
    get() = _animeAiring

    private var _animeUpcoming = MutableLiveData<List<AnimeListResponse>>()
    val animeUpcoming: LiveData<List<AnimeListResponse>>
        get() = _animeUpcoming

    private var _animeTV = MutableLiveData<List<AnimeListResponse>>()
    val animeTV: LiveData<List<AnimeListResponse>>
        get() = _animeTV

    init {
        coroutineScope.launch {
            try {
                val resultAiring = repository.getTopAnime("airing")
                _animeAiring.value = resultAiring

                val resultUpcoming = repository.getTopAnime("upcoming")
                _animeUpcoming.value = resultUpcoming

                val resultTV = repository.getTopAnime("tv")
                _animeTV.value = resultTV
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}