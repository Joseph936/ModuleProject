package cn.clp.common.utils.Https.request

import okhttp3.Request

class DeleteRequest<T>(url:String) :BaseRequest<T,DeleteRequest<T>>(url){
    override fun createUrl(): String? {
        TODO("Not yet implemented")
    }

    override fun createRequest(): Request? {
        TODO("Not yet implemented")
    }

    override fun createRequestBuilder(): Request.Builder? {
        TODO("Not yet implemented")
    }
}