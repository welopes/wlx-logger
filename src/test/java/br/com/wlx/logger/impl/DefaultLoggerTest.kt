package br.com.wlx.logger.impl

import br.com.wlx.logger.api.Logger
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import java.util.logging.Level
import java.util.logging.Logger as JULogger

class DefaultLoggerTest {

    private lateinit var julLogger: JULogger
    private lateinit var logger: Logger

    @Before
    fun setUp() {
        julLogger = mockk(relaxed = true)
        logger = DefaultLoggerTestHelper.createLoggerWithMock(julLogger)
    }

    @Test
    fun verboseShouldCallLogWithLevelFinest() {
        logger.verbose("message")
        verify { julLogger.log(Level.FINEST, "message") }
    }

    @Test
    fun debugShouldCallLogWithLevelFine() {
        logger.debug("message")
        verify { julLogger.log(Level.FINE, "message") }
    }

    @Test
    fun infoShouldCallLogWithLevelInfo() {
        logger.info("message")
        verify { julLogger.log(Level.INFO, "message") }
    }

    @Test
    fun warningShouldCallLogWithLevelWarning() {
        logger.warning("message")
        verify { julLogger.log(Level.WARNING, "message") }
    }

    @Test
    fun errorShouldCallLogWithLevelSevereAndThrowable() {
        val throwable = RuntimeException("error")
        logger.error("message", throwable)
        verify { julLogger.log(Level.SEVERE, "message", throwable) }
    }
}

object DefaultLoggerTestHelper {
    fun createLoggerWithMock(mockLogger: JULogger): Logger {
        return object : Logger {
            override fun verbose(message: String) = mockLogger.log(Level.FINEST, message)
            override fun debug(message: String) = mockLogger.log(Level.FINE, message)
            override fun info(message: String) = mockLogger.log(Level.INFO, message)
            override fun warning(message: String) = mockLogger.log(Level.WARNING, message)
            override fun error(message: String, throwable: Throwable?) =
                mockLogger.log(Level.SEVERE, message, throwable)
        }
    }
}