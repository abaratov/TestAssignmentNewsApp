# NewsApp
## Overview
**TestAssignmentNewsApp** is an Android application built using Jetpack Compose for the UI, Retrofit for network requests and Hilt for dependency injection. The application fetches the latest news articles from the NewsAPI and displays them in a list. This project demonstrates the use of modern Android development practices, including MVVM architecture, Kotlin Coroutines, and StateFlow.

## Features
Display a list of the latest news articles.
Fetch news data from NewsAPI using Retrofit.
Handle different states such as loading, success, and error using StateFlow and Jetpack Compose.
Dependency injection with Hilt.
Image loading with Coil.

## Tech Stack
**Language**: Kotlin

**UI**: Jetpack Compose

**Networking**: Retrofit

**Dependency Injection**: Hilt

**Asynchronous Operations**: Kotlin Coroutines

**Image Loading**: Coil

**Architecture**: MVVM (Model-View-ViewModel)

## Getting Started
1. Clone the repository

```
https://github.com/abaratov/TestAssignmentNewsApp.git
```

2. Obtain an API key from NewsAPI

- You need an API key from [NewsAPI](https://newsapi.org/) to fetch news data. Sign up and get your free API key.

3. Build and Run
Open the project in Android Studio and sync the Gradle files. After syncing, you can build and run the project:

- **Build**: Build > Make Project
- **Run**: Select the device or emulator and click Run
