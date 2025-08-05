package br.com.wlx.logger.impl

import android.util.Log
import br.com.wlx.logger.api.LogType
import br.com.wlx.logger.api.Logger

class DefaultLogger(private val currentTag: String? = null) : Logger {

    override fun tag(tag: String): Logger = DefaultLogger(tag)

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
        val tag = currentTag ?: "DefaultLogger"

        when (logType) {
            LogType.VERBOSE -> Log.v(tag, msg, throwable)
            LogType.DEBUG -> Log.d(tag, msg, throwable)
            LogType.INFO -> Log.i(tag, msg, throwable)
            LogType.ANALYTICS -> Log.i(tag, msg, throwable)
            LogType.WARN -> Log.w(tag, msg, throwable)
            LogType.ERROR -> Log.e(tag, msg, throwable)
            LogType.FATAL -> Log.wtf(tag, msg, throwable)
        }
    }
}
