package com.masscode.manime.views.season

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class SeasonViewModel(private val repository: Repository): ViewModel() {

    private val vmJob = Job()
    private val coroutineScope = CoroutineScope(vmJob + Dispatchers.Main)

    private var year by Delegates.notNull<Int>()
    private lateinit var season: String

    fun setSeason(year: Int, season: String) {
        this.year = year
        this.season = season

        coroutineScope.launch {
            try {
                val resultAiring = repository.getSeasonAnime(year, season)
                _animeSeason.value = resultAiring
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    private var _animeSeason = MutableLiveData<List<AnimeListResponse>>()
    val animeSeason: LiveData<List<AnimeListResponse>>
        get() = _animeSeason

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}