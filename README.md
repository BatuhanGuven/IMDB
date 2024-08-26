IMDB Movie App - README
========================

## Overview

This is an Android application built using Kotlin and Jetpack Compose. The app allows users to search for movies using the IMDB API, view detailed information about each movie, and navigate through different screens to explore movie details.

## Features

- **Search Movies**: Users can search for movies by name using the IMDB API.
- **Movie Details**: View detailed information about a selected movie, including actors, awards, country, director, IMDb rating, and more.
- **Navigation**: Navigate between different screens, including the search results and detailed movie information.
- **Modern UI**: Built with Jetpack Compose for a modern, responsive user interface.

## Technologies Used

- **Kotlin**: The primary programming language for the app.
- **Jetpack Compose**: For building the user interface.
- **Retrofit**: For making network requests to the IMDB API.
- **Coil**: For loading images asynchronously.
- **Kotlinx Serialization**: For parsing JSON responses from the API.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/imdb-movie-app.git
   ```
2. Open the project in Android Studio.

3. Sync the project with Gradle.

4. Build and run the app on an emulator or a physical device.

## Usage

1. **Home Screen**:
   - Enter the name of a movie in the search bar.
   - Click the "Ara" button to search for the movie.

2. **Search Results**:
   - A list of movies matching the search term will be displayed.
   - Click on any movie to view its details.

3. **Movie Details**:
   - View detailed information about the movie, such as title, year, actors, awards, and more.
   - Use the back button to return to the previous screen.

## API Key

To use the IMDB API, an API key is required. Replace the placeholder API key in the code with your actual API key.

```kotlin
val call = apiService.getData(
    "apikey YOUR_API_KEY_HERE",
    "application/json",
    query!!
)
```

## Dependencies

- `implementation "androidx.compose.ui:ui:1.0.5"`
- `implementation "androidx.compose.material3:material3:1.0.0-alpha03"`
- `implementation "androidx.activity:activity-compose:1.3.1"`
- `implementation 'com.squareup.retrofit2:retrofit:2.9.0'`
- `implementation 'com.squareup.retrofit2:converter-gson:2.9.0'`
- `implementation 'io.coil-kt:coil-compose:1.3.2'`
- `implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0"`

