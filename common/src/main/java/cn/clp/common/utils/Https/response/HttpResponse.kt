package cn.clp.common.utils.Https.response

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class HttpResponse<T:Any> {
    var result: T? = null
    var isConnectNetWork = false
}