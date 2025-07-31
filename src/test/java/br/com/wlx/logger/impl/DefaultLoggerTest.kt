package br.com.wlx.logger.impl

import br.com.wlx.logger.api.LogType
import br.com.wlx.logger.api.Logger
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import java.util.logging.Level
import java.util.logging.Logger as JULogger

class DefaultLoggerTest {

    private lateinit var mockJulLogger: JULogger
    private lateinit var logger: Logger

    @Before
    fun setUp() {
        mockJulLogger = mockk(relaxed = true)
        logger = DefaultLogger(mockJulLogger)
    }

    @Test
    fun debugShouldCallLogWithLevelFine() {
        val msg = "message"
        logger.debug(msg)
        verify { mockJulLogger.log(Level.FINE, getMessageWithEmoji(LogType.DEBUG, msg)) }
    }

    @Test
    fun infoShouldCallLogWithLevelInfo() {
        val msg = "message"
        logger.info(msg)
        verify { mockJulLogger.log(Level.INFO, getMessageWithEmoji(LogType.INFO, msg)) }
    }

    @Test
    fun warningShouldCallLogWithLevelWarning() {
        val msg = "message"
        logger.warn(msg)
        verify { mockJulLogger.log(Level.WARNING, getMessageWithEmoji(LogType.WARN, msg)) }
    }

    @Test
    fun analyticsShouldCallLogWithLevelWarning() {
        val msg = "message"
        logger.analytics(msg)
        verify { mockJulLogger.log(Level.INFO, getMessageWithEmoji(LogType.ANALYTICS, msg)) }
    }

    @Test
    fun errorShouldCallLogWithLevelSevereAndThrowable() {
        val throwable = RuntimeException("error")
        logger.error(throwable)
        verify {
            mockJulLogger.log(
                Level.SEVERE,
                getMessageWithEmoji(LogType.ERROR, throwable.message ?: ""),
                throwable
            )
        }
    }

    @Test
    fun errorShouldCallLogWithLevelSevereAndMessageAndThrowable() {
        val msg = "message"
        val throwable = RuntimeException("error")
        logger.error(msg, throwable)
        verify {
            mockJulLogger.log(
                Level.SEVERE,
                getMessageWithEmoji(LogType.ERROR, msg),
                throwable
            )
        }
    }

    private fun getMessageWithEmoji(level: LogType, message: String): String {
        return "${level.getEmojiByType()} $message"
    }
}