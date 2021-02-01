package cn.clp.common.utils.Https.request

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.text.TextUtils
import android.webkit.WebView
import cn.clp.common.utils.GlobalContextUtil
import cn.clp.common.utils.Https.HttpUtil
import cn.clp.common.utils.Https.model.HttpHeaders
import cn.clp.common.utils.Https.model.HttpParams
import cn.clp.common.utils.Https.response.Callback
import okhttp3.Call
import okhttp3.Headers
import okhttp3.Response
import java.io.IOException
import java.net.URLEncoder
import java.util.*


abstract class BaseRequest<T, R> : RequestInterface {
    private var context = GlobalContextUtil.newInstance().getContext()
    private var acceptLanguage: String? = null
    private var httpHeaders: HttpHeaders? = null
    private var httpParams: HttpParams? = null
    private var executed = false
    private var retryCount = 0
    private var currentRetryCount = 0
    protected var url: String? = null
    protected var tag: String? = null

    enum class MethodType(type: String) {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE"),
        PATCH("PATCH");
    }

    init {
        httpHeaders = HttpHeaders()
//        acceptLanguage?.let { addHeaders(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, it) }
//        addHeaders(HttpHeaders.HEAD_KEY_USER_AGENT, getUserAgent())
        httpParams = HttpParams()
    }

    fun getUserAgent(): String {
        return WebView(context).settings.userAgentString
    }

    fun setAcceptLanguage(language: String) {
        this.acceptLanguage = acceptLanguage
    }

    fun addCommonParam(key: String, value: String): BaseRequest<T, R> {
        httpParams?.put(key, value)
        return this
    }

    fun addCommonParams(httpParams: HttpParams): BaseRequest<T, R> {
        this.httpParams = httpParams
        return this
    }

    fun addCommonParam(key: String, value: HttpParams.FileWrapper): BaseRequest<T, R> {
        httpParams?.put(key, value)
        return this
    }

    fun addCommonParam(key: String, value: List<HttpParams.FileWrapper>): BaseRequest<T, R> {
        httpParams?.put(key, value)
        return this
    }

    fun getCommonParams(): HttpParams? {
        return httpParams;
    }

    fun addHeader(key: String, value: String): BaseRequest<T, R> {
        httpHeaders?.put(key, value)
        return this
    }

    fun addHeaders(httpHeaders: HttpHeaders): BaseRequest<T, R> {
        this.httpHeaders = httpHeaders
        return this
    }

    fun getHeaders(): HttpHeaders? {
        return httpHeaders
    }

    fun getAcceptLanguage(): String? {
        if (TextUtils.isEmpty(acceptLanguage)) {
            var local = Locale.getDefault()
            var country = local.country
            var language = local.language
            var acceptLanguageBuilder = StringBuilder(language)
            acceptLanguageBuilder.append('-').append(country).append(",").append(language).append(";q=0.8")
            acceptLanguage = acceptLanguageBuilder.toString()
            return acceptLanguage
        }
        return acceptLanguage
    }

    fun setUrl(url: String): BaseRequest<T, R> {
        this.url = url
        return this
    }

    fun setRetryCount(retryCount: Int): BaseRequest<T, R> {
        this.retryCount = retryCount
        return this
    }

    fun createUrlFromParams(realHttpParams: HttpParams): String? {
        var realUrl: String? = null
        try {
            var stringBuilder = StringBuilder()
            stringBuilder.append(url)
            if (url.let { it?.indexOf('&') }!! > 0 || url.let { it?.indexOf('?') }!! > 0) {
                stringBuilder.append("&")
            } else {
                stringBuilder.append("?")
            }
            var urlParamsMap = realHttpParams.getUrlParams()
            urlParamsMap?.let {
                for ((urlParamKey, urlParamsValue) in it) {
                    var value = URLEncoder.encode(urlParamsValue, "UTF-8");
                    stringBuilder.append(urlParamKey).append("=").append(value).append("&")
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length - 1)

        } catch (except: Exception) {
        }
        return realUrl
    }

    fun createUrlFromHeaders(realHttpHeaders: HttpHeaders): Headers.Builder? {
        var headersMap = realHttpHeaders.getHeaders()
        var headerBuilder = Headers.Builder()
        headersMap?.let {
            for ((key, value) in it) {
                headerBuilder.add(key, value)
            }
        }
        return headerBuilder
    }

    fun <T> execute(flag: String, callBack: Callback<T>) {
        this.tag = flag
        var call = createRequest()?.let { HttpUtil.newInstance().getOkHttpClient()?.newCall(it) }
        call?.enqueue(object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {
                if (currentRetryCount < retryCount) {
                    execute(flag, callBack)
                    currentRetryCount++
                } else {
                    callBack.onErrorRequest(flag, isNetworkConnected())
                }
            }
            override fun onResponse(call: Call, response: Response) {
                callBack.convertResponse(flag, response)
            }
        })
    }

    fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= 23) {
            val networkCapabilities = cm.getNetworkCapabilities(cm.activeNetwork)
            networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            var netWorkInfo = cm.activeNetworkInfo
            netWorkInfo.isConnected
        }

        return false
    }
}