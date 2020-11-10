package com.masscode.manime.views.features.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.response.CharactersListResponse
import com.masscode.manime.data.source.remote.response.DetailAnimeResponse
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class DetailAnimeViewModel(private val repository: Repository) : ViewModel() {

    private var id by Delegates.notNull<Int>()

    private var _anime = MutableLiveData<DetailAnimeResponse>()
    val anime: LiveData<DetailAnimeResponse>
        get() = _anime

    private var _characters = MutableLiveData<List<CharactersListResponse>>()
    val characters: LiveData<List<CharactersListResponse>>
        get() = _characters

    fun setDetailAnime(id: Int) {
        this.id = id

        viewModelScope.launch {
            val detailAnime = repository.getDetailAnime(id)
            _anime.value = detailAnime

            val characters = repository.getCharacters(id)
            _characters.value = characters
        }
    }
}