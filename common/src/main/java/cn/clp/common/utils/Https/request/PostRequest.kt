package cn.clp.common.utils.Https.request

import okhttp3.Request
import okhttp3.RequestBody

class PostRequest<T> : BodyRequest<T>() {
    override fun createUrl(): String? {
        return url

//        return getCommonParams()?.let {
//            createUrlFromParams(it)
//            return url
//        }
    }

    override fun createRequest(): Request? {
        var requestBody = createRequestBody()
        var requestBuilder = createRequestBuilder()
        requestBuilder = requestBuilder?.post(requestBody)
        requestBuilder = createUrl()?.let {
            requestBuilder?.url(it)
        }
        requestBuilder = requestBuilder?.tag(tag)
        return requestBuilder?.build()
    }
}