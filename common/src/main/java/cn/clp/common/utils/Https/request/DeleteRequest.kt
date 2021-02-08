package cn.clp.common.utils.Https.request

import okhttp3.Request

class DeleteRequest<T>(url: String) : BodyRequest<T, DeleteRequest<T>>(url) {
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
        requestBuilder = requestBody?.let { requestBuilder?.delete(it) }
        requestBuilder = createUrl()?.let {
            requestBuilder?.url(it)
        }
        requestBuilder = requestBuilder?.tag(tag)
        return requestBuilder?.build()
    }
}