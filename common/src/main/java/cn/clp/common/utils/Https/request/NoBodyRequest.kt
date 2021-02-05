package cn.clp.common.utils.Https.request

import okhttp3.Request

abstract class NoBodyRequest<T,R:NoBodyRequest<T,R>>(url: String) : BaseRequest<T, NoBodyRequest<T,R>>(url) {
    override fun createRequestBuilder(): Request.Builder? {
        var requestBuilder = Request.Builder()
        var headerBuilders = getHeaders()?.let {
            createUrlFromHeaders(it)
        }
        return headerBuilders?.build()?.let {
            requestBuilder.headers(it)
        }
    }
}