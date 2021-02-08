package cn.clp.common.utils.Https

import cn.clp.common.utils.GlobalContextUtil
import cn.clp.common.utils.Https.interceptors.LoggingInterceptor
import cn.clp.common.utils.Https.response.HttpHeaders
import cn.clp.common.utils.Https.request.*
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class HttpUtil : HttpRequestInterface {
    private var context = GlobalContextUtil.newInstance().getContext()
    private var okHttpClient: OkHttpClient? = null
    private val DEFAULT_MILLISECONDS: Long = 60;      //默认的超时时间
    private var httpHeader: HttpHeaders? = null

    companion object {
        fun newInstance(): HttpUtil {
            return HttpUtilInner.newInstance
        }
    }

    private class HttpUtilInner {
        companion object {
            var newInstance = HttpUtil()
        }
    }

    private constructor()

    init {
        okHttpClient = OkHttpClient()
        var builder = getOkHttpBuilder()
        //todo 添加校验
        okHttpClient = builder.build()
    }

    fun getOkHttpClient(): OkHttpClient? {
        return okHttpClient
    }

    fun initHttpHeader(httpHeader: HttpHeaders) {
        this.httpHeader = httpHeader
    }

    private fun getOkHttpBuilder(): OkHttpClient.Builder {
        var builder = OkHttpClient.Builder()
        var interceptor = getLoggingInterceptor()
        builder.addInterceptor(interceptor)

        builder.readTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
        builder.writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
        builder.connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
        return builder
    }

    private fun getLoggingInterceptor(): LoggingInterceptor {
        var interceptor = LoggingInterceptor()
        interceptor.setLevel(LoggingInterceptor.Level.BODY)
        return interceptor
    }

    fun <T> getRequest(url: String): NoBodyRequest<T, GetRequest<T>>? {
        return GetRequest<T>(url).addHeaders(httpHeader)
    }

    fun <T> postRequest(url: String): BodyRequest<T, PostRequest<T>>? {
        return PostRequest<T>(url).addHeaders(httpHeader)
    }

    fun <T> deleteRequest(): BaseRequest<T, DeleteRequest<T>> {
        TODO("Not yet implemented")
    }

    fun <T> putRequest(): BaseRequest<T, PutRequest<T>> {
        TODO("Not yet implemented")
    }

    fun <T> patchRequest(): BaseRequest<T, PatchRequest<T>> {
        TODO("Not yet implemented")
    }

    /**
     * 取消制定请求
     */
    fun cancelRequest(tag: Any) {
        var listCall = getOkHttpClient()?.dispatcher?.queuedCalls()
        listCall?.let {
            for (call in it) {
                if (tag.equals(call.request().tag())) {
                    call.cancel()
                }
            }
        }
        var listRunningCall = getOkHttpClient()?.dispatcher?.runningCalls()
        listRunningCall?.let {
            for (call in it) {
                if (tag.equals(call.request().tag())) {
                    call.cancel()
                }
            }
        }
    }

    /**
     * 取消所有请求
     */
    fun cancelAllRequest() {
        var listCall = getOkHttpClient()?.dispatcher?.queuedCalls()
        listCall?.let {
            for (call in it) {
                call.cancel()
            }
        }
        var listRunningCall = getOkHttpClient()?.dispatcher?.runningCalls()
        listRunningCall?.let {
            for (call in it) {
                call.cancel()
            }
        }
    }
}