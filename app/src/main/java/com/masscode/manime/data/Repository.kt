package com.masscode.manime.data

import com.masscode.manime.data.source.remote.RemoteDataSource
import com.masscode.manime.data.source.remote.response.AnimeListResponse
import com.masscode.manime.data.source.remote.response.CharactersListResponse
import com.masscode.manime.data.source.remote.response.DetailAnimeResponse

class Repository private constructor(private val remoteDataSource: RemoteDataSource) : DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData)
            }
    }

    override suspend fun getTopAnime(type: String): List<AnimeListResponse> {
        lateinit var animeResult: List<AnimeListResponse>
        remoteDataSource.getTopAnime(type, object : RemoteDataSource.GetAnimeCallback {
            override fun onAnimeReceived(animeList: List<AnimeListResponse>) {
                animeResult = animeList
            }
        })
        return animeResult
    }

    override suspend fun getDetailAnime(id: Int): DetailAnimeResponse {
        lateinit var animeDetail: DetailAnimeResponse
        remoteDataSource.getDetailAnime(id, object : RemoteDataSource.GetDetailCallback {
            override fun onAnimeReceived(anime: DetailAnimeResponse) {
                animeDetail = anime
            }
        })
        return animeDetail
    }

    override suspend fun getSeasonAnime(year: Int, season: String): List<AnimeListResponse> {
        lateinit var animeSeason: List<AnimeListResponse>
        remoteDataSource.getSeasonAnime(year, season, object : RemoteDataSource.GetAnimeCallback {
            override fun onAnimeReceived(animeList: List<AnimeListResponse>) {
                animeSeason = animeList
            }
        })
        return animeSeason
    }

    override suspend fun getSearchAnime(query: String): List<AnimeListResponse> {
        lateinit var animeResult: List<AnimeListResponse>
        remoteDataSource.getSearchAnime(query, object : RemoteDataSource.GetAnimeCallback {
            override fun onAnimeReceived(animeList: List<AnimeListResponse>) {
                animeResult = animeList
            }
        })
        return animeResult
    }

    override suspend fun getCharacters(id: Int): List<CharactersListResponse> {
        lateinit var charactersResult: List<CharactersListResponse>
        remoteDataSource.getCharacters(id, object : RemoteDataSource.GetCharactersCallback {
            override fun onCharactersReceived(characters: List<CharactersListResponse>) {
                charactersResult = characters
            }
        })
        return charactersResult
    }
}