package cn.clp.common.utils.Https.request

import okhttp3.Request

class GetRequest<T> : NoBodyRequest<T>() {
    override fun createUrl(): String? {
        return getCommonParams()?.let {
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