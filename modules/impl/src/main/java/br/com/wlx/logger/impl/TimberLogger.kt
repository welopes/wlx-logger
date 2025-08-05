package br.com.wlx.logger.impl

import br.com.wlx.logger.api.LogType
import br.com.wlx.logger.api.Logger
import timber.log.Timber

class TimberLogger(private val currentTag: String? = null) : Logger {

    override fun tag(tag: String): Logger = TimberLogger(tag)

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

    override fun log(logType: LogType, message: String, throwable: Throwable?) {
        val msg = "${logType.getEmojiByType()} $message"

        val timber = currentTag?.let { Timber.tag(it) } ?: Timber

        when (logType) {
            LogType.VERBOSE -> timber.v(throwable, msg)
            LogType.DEBUG -> timber.d(throwable, msg)
            LogType.INFO -> timber.i(throwable, msg)
            LogType.ANALYTICS -> timber.i(throwable, msg)
            LogType.WARN -> timber.w(throwable, msg)
            LogType.ERROR -> timber.e(throwable, msg)
            LogType.FATAL -> timber.e(throwable, msg)
        }
    }
}