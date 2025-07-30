package br.com.wlx.log.impl

import br.com.wlx.log.api.Logger
import java.util.logging.Level
import java.util.logging.Logger as JULogger

class DefaultLogger private constructor(
    private val tag: String
) : Logger {

    private val logger: JULogger = JULogger.getLogger(tag)

    init {
        logger.useParentHandlers = true
    }

    override fun verbose(message: String) = logger.log(Level.FINEST, message)

    override fun debug(message: String) = logger.log(Level.FINE, message)

    override fun info(message: String) = logger.log(Level.INFO, message)

    override fun warning(message: String) = logger.log(Level.WARNING, message)

    override fun error(message: String, throwable: Throwable?) =
        logger.log(Level.SEVERE, message, throwable)

    companion object {
        fun get(tag: String): Logger = DefaultLogger(tag)
    }
}
