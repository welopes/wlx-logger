package br.com.wlx.logger.api

import java.util.logging.Level

enum class LogType(val loggerLevel: Level) {
    DEBUG(Level.FINE),
    INFO(Level.INFO),
    WARN(Level.WARNING),
    ANALYTICS(Level.INFO),
    ERROR(Level.SEVERE);

    fun getEmojiByType(): String {
        return when (this) {
            DEBUG -> " 🔍  DEBUG  🔍 "
            INFO -> " ℹ️   INFO    ℹ️ "
            WARN -> " ⚠️  WARNING  ⚠️ "
            ERROR -> " ❗   ERROR    ❗"
            ANALYTICS -> " 📊 ANALYTICS 📊 "
        }
    }
}