package br.com.wlx.logger.impl

import br.com.wlx.logger.api.LogType
import br.com.wlx.logger.api.Logger
import java.util.logging.Logger as JULogger

class DefaultLogger(
    val logger: JULogger
) : Logger {

    override fun debug(message: String) {
        log(LogType.DEBUG, message)
    }

    override fun info(message: String) {
        log(LogType.INFO, message)
    }

    override fun warn(message: String) {
        log(LogType.WARN, message)
    }

    override fun analytics(message: String) {
        log(LogType.ANALYTICS, message)
    }

    override fun error(throwable: Throwable) {
        log(LogType.ERROR, throwable.message ?: "", throwable)
    }

    override fun error(message: String, throwable: Throwable?) {
        log(LogType.ERROR, message, throwable)
    }

    override fun log(
        level: LogType,
        message: String,
        throwable: Throwable?
    ) {
        val msg = "${level.getEmojiByType()} $message"
        if (throwable != null) {
            logger.log(level.loggerLevel, msg, throwable)
        } else {
            logger.log(level.loggerLevel, msg)
        }
    }
}
