package network

import java.io.InputStreamReader

class Utils {
    companion object {
        fun mockResponseFileReader(path: String): String {
            val content: String
            val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
            content = reader.readText()
            reader.close()
            return content
        }
    }
}