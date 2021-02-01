package cn.clp.common.utils.Https.request

import okhttp3.Request

interface RequestInterface {
//    fun createMethod(): BaseRequest.MethodType
    fun createUrl(): String?
    fun createRequest(): Request?
    fun createRequestBuilder(): Request.Builder?
}