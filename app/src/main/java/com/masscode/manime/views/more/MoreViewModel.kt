package com.masscode.manime.views.more

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import kotlinx.coroutines.launch

class MoreViewModel(private val repository: Repository) : ViewModel() {

    private lateinit var type: String

    private var _animeAiring = MutableLiveData<List<AnimeListResponse>>()
    val animeAiring: LiveData<List<AnimeListResponse>>
        get() = _animeAiring

    fun setType(type: String) {
        this.type = type

        viewModelScope.launch {
            try {
                val resultAiring = repository.getTopAnime(type)
                _animeAiring.value = resultAiring
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}