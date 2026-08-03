

![GitHub Cards Preview](https://github.com/agustiyann/Manime/blob/main/preview/manime.jpeg?raw=true)

# Manime
![Minimum API](https://img.shields.io/badge/API-21%2B-%2300cec9?style=flat-square)
[![GitHub license](https://img.shields.io/github/license/agustiyann/Manime?style=flat-square)](https://github.com/agustiyann/Manime/blob/main/LICENSE)
[![GitHub Workflow Status](https://img.shields.io/github/workflow/status/agustiyann/Manime/Android%20CI?logo=github&style=flat-square)](https://github.com/agustiyann/Manime/actions)
[![GitHub issues](https://img.shields.io/github/issues/agustiyann/Manime?style=flat-square)](https://github.com/agustiyann/Manime/issues)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue?logo=kotlin&style=flat-square)](https://kotlinlang.org)
[![GitHub](https://img.shields.io/badge/GitHub-agustiyann-%2300b894?logo=github&style=flat-square)](https://github.com/agustiyann)

Manime es una aplicación para ver las listas de anime más populares y recientes, así como listas organizadas por temporada, con detalles completos sobre cada anime. Está basada en la arquitectura MVVM,
componentes de arquitectura y el patrón de repositorio.

<img src="/preview/manime.gif" align="right"/>

## Características
Todos los datos se obtienen de [Jikan API](https://jikan.moe), y la documentación puede verse [aquí](https://jikan.docs.apiary.io).
- Top Anime
  - En emisión
  - Próximos
  - TV
  - Películas
- Temporadas
  - Primavera
  - Verano
  - Otoño
  - Invierno
- Detalles
- Búsqueda

## Stack Tecnológico
- Basado en [Kotlin](https://kotlinlang.org/).
- Arquitectura MVVM
- Componentes de Arquitectura
- Patrón de Repositorio
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Administrador de datos relacionados con la IU, consciente del ciclo de vida.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notifica los datos de la capa de dominio a las vistas.
- [Data Binding](https://developer.android.com/topic/libraries/data-binding) - Vincula componentes de la IU en los diseños con fuentes de datos.
- [Navigation Component](https://developer.android.com/guide/navigation) - Navega hacia, dentro y fuera de las diferentes secciones de contenido dentro de tu aplicación.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Para operaciones asíncronas.
- [Retrofit2](https://github.com/square/retrofit)  - Construcción de APIs REST y paginación de datos de red.
- [Moshi](https://github.com/square/moshi) - Una biblioteca JSON moderna para Kotlin y Java.
- [OkHttp3](https://square.github.io/okhttp/) - Interceptor de registro/logging.
- [Glide](https://github.com/bumptech/glide) - Carga de imágenes.
- [Material-Components](https://github.com/material-components/material-components-android)  - Componentes de diseño Material.
- [Lottie](https://lottiefiles.com/) - Muestra animaciones en formato JSON.
- [Shimmer](https://facebook.github.io/shimmer-android/) - Crea un efecto de brillo en la aplicación.

## Descarga
Ve a [Releases](https://github.com/agustiyann/Manime/releases) para descargar el APK más reciente.

## Contribuir
¡Si deseas contribuir a este repositorio, siempre eres bienvenido/a!

## Stargazers
[![Stargazers repo roster for @agustiyann/Manime](https://reporoster.com/stars/agustiyann/Manime)](https://github.com/agustiyann/Manime/stargazers)

## Licencia
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
