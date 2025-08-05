package br.com.wlx.logger.api

object LoggerFactory {

    enum class Type {
        DEFAULT, TIMBER, JUL
    }

    fun create(type: Type = Type.DEFAULT): Logger {
        return try {
            val className = when (type) {
                Type.DEFAULT -> "br.com.wlx.impl.DefaultLogger"
                Type.TIMBER -> "br.com.wlx.impl.TimberLogger"
                Type.JUL -> "br.com.wlx.impl.JULLogger"
            }

            val clazz = Class.forName(className)
            clazz.getDeclaredConstructor().newInstance() as Logger

        } catch (e: Exception) {
            throw IllegalStateException("Logger implementation not found. Did you include the impl module?", e)
        }
    }
}
