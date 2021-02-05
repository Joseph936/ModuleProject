package cn.clp.common.utils.Https.request

import okhttp3.HttpUrl
import okhttp3.Request

class GetRequest<T>(url: String) : NoBodyRequest<T,GetRequest<T>>(url) {
    override fun createUrl(): String? {
        return getHttpParams()?.let {
            createUrlFromParams(it)
            return url
        }
    }

    override fun createRequest(): Request? {
        var requestBuilder = createRequestBuilder()
        requestBuilder = requestBuilder?.get()
        requestBuilder = createUrl()?.let {
            requestBuilder?.url(it)
        }
        requestBuilder = requestBuilder?.tag(tag)
        return requestBuilder?.build()
    }
}