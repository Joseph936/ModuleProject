package cn.clp.common.utils.Https.request

import okhttp3.FormBody
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

abstract class BodyRequest<T,R:BodyRequest<T,R>>(url: String) : BaseRequest<T, BodyRequest<T,R>>(url) {
    private var isMultipart = false//是否强制使用 multipart/form-data 表单上传
    protected var isSpliceUrl = false//

    fun setAddUrlFromParam(addUrlFromParam: Boolean): BodyRequest<T,R> {
        this.isSpliceUrl = addUrlFromParam
        return this
    }

    fun setMultipart(isMultipart: Boolean) {
        this.isMultipart = isMultipart
    }

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
        var urlParamsMap = getHttpParams()?.getUrlParams()
        if (isMultipart) {
            var multipartBodybuilder = MultipartBody.Builder()
            urlParamsMap?.let {
                for ((urlParamKey, urlParamsValue) in it) {
                    multipartBodybuilder.addFormDataPart(urlParamKey, urlParamsValue)
                }
            }
            var fileParamsMap = getHttpParams()?.getFileParams()
            fileParamsMap?.let {
                for ((fileParamKey, fileWrapperListValue) in it) {
                    for (fileValue in fileWrapperListValue) {
                        var fileBody = fileValue.file.toString().toRequestBody(fileValue.contentType)
                        multipartBodybuilder.addFormDataPart(fileParamKey, fileValue.fileName, fileBody)

                    }
                }
            }
            return multipartBodybuilder.build()
        } else {
            var bodyBuilder = FormBody.Builder()
            urlParamsMap?.let {
                for ((urlParamKey, urlParamsValue) in it) {
                    bodyBuilder.addEncoded(urlParamKey, urlParamsValue)
                }
            }
            return bodyBuilder.build()
        }
    }

}