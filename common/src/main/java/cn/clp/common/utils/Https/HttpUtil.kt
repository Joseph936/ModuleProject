package cn.clp.common.utils.Https

import android.text.TextUtils
import android.util.Log
import cn.clp.common.utils.GlobalContextUtil
import cn.clp.common.utils.Https.interceptors.LoggingInterceptor
import cn.clp.common.utils.Https.model.HttpParams
import cn.clp.common.utils.Https.request.*
import cn.clp.common.utils.Https.response.Callback
import cn.clp.common.utils.Https.response.HttpResponse
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

class HttpUtil : HttpRequestInterface {
    private var context = GlobalContextUtil.newInstance().getContext()
    private var okHttpClient: OkHttpClient? = null
    private val DEFAULT_MILLISECONDS: Long = 60;      //默认的超时时间

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

    fun <T> getRequest(url: String, params: LinkedHashMap<String, String>, retryCount: Int): BaseRequest<T, GetRequest<T>> {
        var httpParams = HttpParams()
        httpParams.putAll(params)
        return GetRequest<T>().setUrl(url).setRetryCount(retryCount).addCommonParams(httpParams)
    }

    fun <T> getRequest(url: String, params: LinkedHashMap<String, String>): BaseRequest<T, GetRequest<T>> {
        return getRequest(url, params, 0)
    }

    fun <T> postRequest(): BaseRequest<T, PostRequest<T>> {
        TODO("Not yet implemented")
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