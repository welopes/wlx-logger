# 🧩 wlx-logger

**wlx-logger** is a lightweight and elegant Kotlin logging library designed to make application logging more readable, structured, and developer-friendly.  
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

## 💻 Example Usage

```kotlin
val logger = WlxLogger(tag = "MainActivity")

logger.debug("App started successfully")
logger.info("User logged in with ID: $userId")
logger.warn("Low memory warning")
logger.error("Unhandled exception", exception)
