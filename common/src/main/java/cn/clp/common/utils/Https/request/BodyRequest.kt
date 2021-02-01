package cn.clp.common.utils.Https.request

import okhttp3.Request
import okhttp3.RequestBody

abstract class BodyRequest<T> : BaseRequest<T, BodyRequest<T>>() {
    private var isMultipart = false//是否强制使用 multipart/form-data 表单上传
    private var isSpliceUrl = false//

    override fun createRequestBuilder(): Request.Builder? {
        var requestBuilder = Request.Builder()
        var headerBuilders = getHeaders()?.let {
            createUrlFromHeaders(it)
        }
        return headerBuilders?.build()?.let {
            requestBuilder.headers(it)
        }
    }

    protected fun createRequestBody(): RequestBody? {
        return null
    }
}