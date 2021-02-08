package cn.clp.common.utils.Https.response

/**
 * 请求头信息
 */
class HttpHeaders {
    companion object {
        const val HEAD_KEY_RESPONSE_CODE = "ResponseCode"
        const val HEAD_KEY_RESPONSE_MESSAGE = "ResponseMessage"
        const val HEAD_KEY_ACCEPT = "Accept"
        const val HEAD_KEY_ACCEPT_ENCODING = "Accept-Encoding"
        const val HEAD_VALUE_ACCEPT_ENCODING = "gzip, deflate"
        const val HEAD_KEY_ACCEPT_LANGUAGE = "Accept-Language"
        const val HEAD_KEY_CONTENT_TYPE = "Content-Type"
        const val HEAD_KEY_CONTENT_LENGTH = "Content-Length"
        const val HEAD_KEY_CONTENT_ENCODING = "Content-Encoding"
        const val HEAD_KEY_CONTENT_DISPOSITION = "Content-Disposition"
        const val HEAD_KEY_CONTENT_RANGE = "Content-Range"
        const val HEAD_KEY_RANGE = "Range"
        const val HEAD_KEY_CACHE_CONTROL = "Cache-Control"
        const val HEAD_KEY_CONNECTION = "Connection"
        const val HEAD_VALUE_CONNECTION_KEEP_ALIVE = "keep-alive"
        const val HEAD_VALUE_CONNECTION_CLOSE = "close"
        const val HEAD_KEY_DATE = "Date"
        const val HEAD_KEY_EXPIRES = "Expires"
        const val HEAD_KEY_E_TAG = "ETag"
        const val HEAD_KEY_PRAGMA = "Pragma"
        const val HEAD_KEY_IF_MODIFIED_SINCE = "If-Modified-Since"
        const val HEAD_KEY_IF_NONE_MATCH = "If-None-Match"
        const val HEAD_KEY_LAST_MODIFIED = "Last-Modified"
        const val HEAD_KEY_LOCATION = "Location"
        const val HEAD_KEY_USER_AGENT = "User-Agent"
        const val HEAD_KEY_COOKIE = "Cookie"
        const val HEAD_KEY_COOKIE2 = "Cookie2"
        const val HEAD_KEY_SET_COOKIE = "Set-Cookie"
        const val HEAD_KEY_SET_COOKIE2 = "Set-Cookie2"
    }

    private var headersMap: LinkedHashMap<String, String>? = null

    init {
        headersMap = LinkedHashMap()
    }

    fun put(key: String, value: String) {
        headersMap?.put(key, value)
    }

    fun get(key: String): String? {
        return headersMap?.get(key)
    }

    fun getHeaders(): LinkedHashMap<String, String>? {
        return headersMap
    }

    fun remove(key: String) {
        headersMap?.remove(key)
    }

    fun clear() {
        headersMap?.clear()
    }

    override fun toString(): String {
        return "HttpHeaders(headersMap=$headersMap)"
    }

}