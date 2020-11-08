package com.masscode.manime.views.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private var _animeAiring = MutableLiveData<List<AnimeListResponse>>()
    val animeAiring: LiveData<List<AnimeListResponse>>
        get() = _animeAiring

    private var _animeUpcoming = MutableLiveData<List<AnimeListResponse>>()
    val animeUpcoming: LiveData<List<AnimeListResponse>>
        get() = _animeUpcoming

    private var _animeTV = MutableLiveData<List<AnimeListResponse>>()
    val animeTV: LiveData<List<AnimeListResponse>>
        get() = _animeTV

    private var _animeMovie = MutableLiveData<List<AnimeListResponse>>()
    val animeMovie: LiveData<List<AnimeListResponse>>
        get() = _animeMovie

    init {
        viewModelScope.launch {
            try {
                val resultAiring = repository.getTopAnime("airing")
                _animeAiring.value = resultAiring

                val resultUpcoming = repository.getTopAnime("upcoming")
                _animeUpcoming.value = resultUpcoming

                val resultTV = repository.getTopAnime("tv")
                _animeTV.value = resultTV

                val resultMovie = repository.getTopAnime("movie")
                _animeMovie.value = resultMovie
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}