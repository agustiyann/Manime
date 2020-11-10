package com.masscode.manime.views.features.season

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class SeasonViewModel(private val repository: Repository) : ViewModel() {

    private var _animeSeason = MutableLiveData<List<AnimeListResponse>>()
    val animeSeason: LiveData<List<AnimeListResponse>>
        get() = _animeSeason

    fun setSeason(year: Int, season: String) {
        viewModelScope.launch {
            try {
                val resultAiring = repository.getSeasonAnime(year, season)
                _animeSeason.value = resultAiring
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}