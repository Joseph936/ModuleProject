package cn.clp.common.utils.Https.request

import okhttp3.Request

class PostRequest<T>(url: String) : BodyRequest<T,PostRequest<T>>(url) {
    override fun createUrl(): String? {
        if (isSpliceUrl) {
            return getHttpParams()?.let {
                createUrlFromParams(it)
            }
        }
        return url
    }

    override fun createRequest(): Request? {
        var requestBody = createRequestBody()
        var requestBuilder = createRequestBuilder()
        requestBuilder = requestBody?.let { requestBuilder?.post(it) }
        requestBuilder = createUrl()?.let {
            requestBuilder?.url(it)
        }
        requestBuilder = requestBuilder?.tag(tag)
        return requestBuilder?.build()
    }
}