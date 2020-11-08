package com.masscode.manime.views.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: Repository) : ViewModel() {

    private var _animeResult = MutableLiveData<List<AnimeListResponse>>()
    val animeResult: LiveData<List<AnimeListResponse>>
        get() = _animeResult

    private lateinit var query: String

    fun setResult(query: String) {
        this.query = query

        viewModelScope.launch {
            try {
                val result = repository.getSearchAnime(query)
                _animeResult.value = result
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}