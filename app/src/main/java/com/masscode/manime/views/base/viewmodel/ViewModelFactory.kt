package com.masscode.manime.views.base.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.masscode.manime.data.Repository
import com.masscode.manime.di.Injection
import com.masscode.manime.views.features.detail.DetailAnimeViewModel
import com.masscode.manime.views.features.home.HomeViewModel
import com.masscode.manime.views.features.more.MoreViewModel
import com.masscode.manime.views.features.search.SearchViewModel
import com.masscode.manime.views.features.season.SeasonViewModel

class ViewModelFactory private constructor(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MoreViewModel::class.java) -> {
                MoreViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailAnimeViewModel::class.java) -> {
                DetailAnimeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(SeasonViewModel::class.java) -> {
                SeasonViewModel(repository) as T
            }
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                SearchViewModel(repository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}