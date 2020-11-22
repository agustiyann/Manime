![GitHub Cards Preview](https://github.com/agustiyann/Manime/blob/main/preview/manime.jpeg?raw=true)

# Manime
![Minimum API](https://img.shields.io/badge/API-21%2B-%2300cec9?style=flat-square)
[![GitHub license](https://img.shields.io/github/license/agustiyann/Manime?style=flat-square)](https://github.com/agustiyann/Manime/blob/main/LICENSE)
[![GitHub Workflow Status](https://img.shields.io/github/workflow/status/agustiyann/Manime/Android%20CI?logo=github&style=flat-square)](https://github.com/agustiyann/Manime/actions)
[![GitHub issues](https://img.shields.io/github/issues/agustiyann/Manime?style=flat-square)](https://github.com/agustiyann/Manime/issues)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue?logo=kotlin&style=flat-square)](https://kotlinlang.org)
[![GitHub](https://img.shields.io/badge/GitHub-agustiyann-%2300b894?logo=github&style=flat-square)](https://github.com/agustiyann)

Manime is an application to view the most popular and newest anime list and to view anime list based on season, there are complete details about the anime. Based on MVVM,
architecture component, and repository pattern.

<img src="/preview/manime.gif" align="right"/>

## Features
All data is taken from [Jikan API](https://jikan.moe), for documentation can be seen [here](https://jikan.docs.apiary.io).
- Top Anime
  - Airing
  - Upcoming
  - TV
  - Movie
- Season
  - Spring
  - Summer
  - Fall
  - Winter
- Detail
- Search

## Tech Stack
- [Kotlin](https://kotlinlang.org/)  based.
- MVVM Architecture
- Architecture component
- Repository Pattern
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - UI related data holder, lifecycle aware.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify domain layer data to views.
- [Data Binding](https://developer.android.com/topic/libraries/data-binding) - bind UI components in layouts to data sources
- [Navigation Component](https://developer.android.com/guide/navigation) - navigate across, into, and back out from the different pieces of content within your app.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - for asynchronous.
- [Retrofit2](https://github.com/square/retrofit)  - construct the REST APIs and paging network data.
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java.
- [OkHttp3](https://square.github.io/okhttp/) - logging interceptor.
- [Glide](https://github.com/bumptech/glide) - loading images.
- [Material-Components](https://github.com/material-components/material-components-android)  - Material design components.
- [Lottie](https://lottiefiles.com/) - displays animation in JSON format.
- [Shimmer](https://facebook.github.io/shimmer-android/) - create a shimmer effect on the application.

## Download
Go to the [Releases](https://github.com/agustiyann/Manime/releases) to download the latest APK.

## Contribute
If you want to contribute to this repository, you're always welcome!

## Stargazers
[![Stargazers repo roster for @agustiyann/Manime](https://reporoster.com/stars/agustiyann/Manime)](https://github.com/agustiyann/Manime/stargazers)

## License
```
   Copyright (C) 2020 Agus Tiyansyah Syam
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```


