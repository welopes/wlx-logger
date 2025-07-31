package br.com.wlx.logger.api

interface Logger {
    fun debug(message: String)
    fun info(message: String)
    fun warn(message: String)
    fun analytics(message: String)
    fun error(throwable: Throwable)
    fun error(message: String, throwable: Throwable? = null)
    fun log(level: LogType, message: String, throwable: Throwable? = null)
}