# 🧩 wlx-logger

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-Library-green?logo=android)](https://developer.android.com)
[![License: CC BY-NC 4.0](https://img.shields.io/badge/License-CC%20BY--NC%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc/4.0/)
[![Status](https://img.shields.io/badge/Status-Active-success)]()

**WLX Logger** is a lightweight and elegant Kotlin logging library designed to make application logging more readable, structured, and developer-friendly.  
It was created as part of my professional toolkit to simplify log management across projects.

---

## 🚀 Overview

Logging should be simple, clear, and consistent — and that’s exactly what `wlx-logger` aims to deliver.  
It provides a small yet powerful API for structured logs with optional tagging, timestamps, and flexible configuration.

---

## ✨ Features

- 🪶 **Lightweight:** Minimal setup, no external dependencies  
- 🧩 **Structured output:** Clean, readable log messages  
- ⚙️ **Configurable:** Choose what and how to log  
- 🧠 **Developer-friendly:** Built with Kotlin idioms and extension functions  
- 📄 **Extensible:** Easily integrate into Android or JVM-based projects  

---

## 💻 Usage Example

```kotlin
val logger = WlxLogger(tag = "MainActivity")

logger.debug("App started successfully")
logger.info("User logged in with ID: $userId")
logger.warn("Low memory warning")
logger.error("Unhandled exception", exception)
```
---

## 🧩 Roadmap

- Default dependency injection setup
- Support for Sentry and Amplitude
- Offline event queue
- Sample Android app demo

---

## 👨‍💻 Author

Wellington Eliel Lopes
Senior Android Developer | Kotlin | Jetpack Compose | Clean Architecture

> I’m passionate about building scalable, maintainable, and developer-friendly tools for Android.
> **WLX Logger** is part of my personal toolkit — a showcase of my approach to clean architecture, modularization, and abstraction.

📍 [GitHub](https://github.com/welopes) • [LinkedIn](https://www.linkedin.com/in/welopes)

---

## 🛡️ License

This project is licensed under the **Creative Commons Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)** license.

You are free to:

- Share
- Adapt

**As long as you:**

- Give appropriate credit to the original author
- **Do not use it for commercial purposes**

More info: [https://creativecommons.org/licenses/by-nc/4.0/](https://creativecommons.org/licenses/by-nc/4.0/)

