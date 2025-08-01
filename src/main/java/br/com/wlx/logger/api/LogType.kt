package br.com.wlx.logger.api

import java.util.logging.Level

enum class LogType(val loggerLevel: Level) {
    VERBOSE(Level.FINEST),
    DEBUG(Level.FINE),
    INFO(Level.INFO),
    ANALYTICS(Level.CONFIG),
    WARN(Level.WARNING),
    ERROR(Level.SEVERE),
    FATAL(Level.SEVERE);

    fun getEmojiByType(): String {
        return when (this) {
            VERBOSE -> " 🔍  VERBOSE  🔍 "
            DEBUG -> " 🛠️   DEBUG   🛠️ "
            INFO -> " ℹ️   INFO    ℹ️ "
            ANALYTICS -> " 📊 ANALYTICS 📊 "
            WARN -> " ⚠️  WARNING  ⚠️ "
            ERROR -> " ❗   ERROR    ❗"
            FATAL -> " 💀   FATAL   💀 "
        }
    }
}