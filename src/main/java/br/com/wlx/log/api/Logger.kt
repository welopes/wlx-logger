package br.com.wlx.log.api

interface Logger {
    fun verbose(message: String)
    fun debug(message: String)
    fun info(message: String)
    fun warning(message: String)
    fun error(message: String, throwable: Throwable? = null)
}