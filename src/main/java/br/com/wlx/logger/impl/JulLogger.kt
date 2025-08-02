package br.com.wlx.logger.impl

import br.com.wlx.logger.api.LogType
import br.com.wlx.logger.api.Logger
import java.util.logging.Level
import java.util.logging.Logger as Jul

class JulLogger(private val currentTag: String? = null) : Logger {
    private val logger = Jul.getLogger(currentTag ?: "JulLogger").apply {
        level = Level.ALL
    }

    override fun tag(tag: String): Logger = JulLogger(tag)

    override fun verbose(message: String) {
        log(LogType.VERBOSE, message)
    }

    override fun debug(message: String) {
        log(LogType.DEBUG, message)
    }

    override fun info(message: String) {
        log(LogType.INFO, message)
    }

    override fun analytics(message: String) {
        log(LogType.ANALYTICS, message)
    }

    override fun warn(message: String) {
        log(LogType.WARN, message)
    }

    override fun error(throwable: Throwable) {
        error(throwable.message ?: "", throwable)
    }

    override fun error(message: String, throwable: Throwable?) {
        log(LogType.ERROR, message, throwable)
    }

    override fun fatal(throwable: Throwable) {
        fatal(throwable.message ?: "", throwable)
    }

    override fun fatal(message: String, throwable: Throwable?) {
        log(LogType.FATAL, message, throwable)
    }

    override fun log(
        logType: LogType,
        message: String,
        throwable: Throwable?
    ) {
        val msg = "${logType.getEmojiByType()} $message"

        if (throwable == null) {
            logger.log(logType.loggerLevel, msg)
            return
        } else {
            logger.log(logType.loggerLevel, msg, throwable)
        }

    }
}