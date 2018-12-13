package io.ktor.client.engine.js.compatible

enum class ENV {
    BROWSER,
    NODE;

    companion object {
        internal fun isNode(): Boolean {
            return NODE == getEnv()
        }

        private fun getEnv(): ENV {
            return if (jsTypeOf("window") === "undefined") {
                NODE
            } else BROWSER
        }
    }
}
