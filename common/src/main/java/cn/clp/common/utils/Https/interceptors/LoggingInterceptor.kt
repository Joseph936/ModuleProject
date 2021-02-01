package cn.clp.common.utils.Https.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor() : Interceptor {
    private var level = Level.NONE

    fun setLevel(level: Level) {
        this.level = level
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (level == Level.NONE) {
            return chain.proceed(request)
        }
        return chain.proceed(request)
    }

    enum class Level {
        NONE,       //不打印log
        BASIC,      //只打印 请求首行 和 响应首行
        HEADERS,    //打印请求和响应的所有 Header
        BODY        //所有数据全部打印
    }
}