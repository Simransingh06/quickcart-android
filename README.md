# quickcart-android
Instant E-Commerce Android App built with Kotlin, Jetpack Compose, MVVM, Room, and Retrofit.
# QuickCart — Instant E-Commerce Android App

A modern, offline-first Android e-commerce application built with Kotlin, Jetpack Compose, and Clean Architecture.

## 🏗 Architecture
Built following Google's recommended **MVVM + Clean Architecture** guidelines.

- **UI Layer:** Jetpack Compose, Material 3, ViewModel, StateFlow
- **Domain Layer:** UseCases, Repository Interfaces
- **Data Layer:** Room Local Cache, Retrofit Remote API, Repository Implementations
- **Dependency Injection:** Hilt

## 🚀 Features
- **Offline Persistence:** Room DB caches product catalog and shopping cart seamlessly.
- **Reactive UI:** Continuous data streams handled using Kotlin Coroutines & Flow.
- **Asynchronous Operations:** Non-blocking UI execution and background sync.

## 🛠 Tech Stack & Libraries
- **Language:** Kotlin
- **UI:** Jetpack Compose
- **Async:** Coroutines, Flow
- **DI:** Dagger-Hilt
- **Network:** Retrofit 2, OkHttp 3
- **Local Database:** Room Persistence Library
