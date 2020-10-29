package com.masscode.manime.di

import android.content.Context
import com.masscode.manime.data.Repository
import com.masscode.manime.data.source.remote.RemoteDataSource
import com.masscode.manime.data.source.remote.network.ApiConfig

object Injection {

    fun provideRepository(context: Context): Repository {
        val api = ApiConfig
        val remoteDataSource = RemoteDataSource.getInstance(api)

        return Repository.getInstance(remoteDataSource)
    }
}