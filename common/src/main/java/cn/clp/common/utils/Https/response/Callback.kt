package cn.clp.common.utils.Https.response

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import okhttp3.Response
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

interface Callback<T> : Convert {
    fun onStartRequest(flag: String)
    fun onSuccessRequest(flag: String, response: HttpResponse<T>)
    fun onErrorRequest(flag: String, hasNetWork: Boolean)
    override fun convertResponse(flag: String, response: Response) {
        var responseContent = response.body
        var httpResponse = HttpResponse<T>()
        var value = httpResponse.result
        val jsonReader = JsonReader(responseContent?.charStream())
        if (value is List<*>) {
            val type: Type = object : TypeToken<T>() {}.type
            httpResponse.result = Gson().fromJson(jsonReader, type)
//            httpResponse.result= Gson().fromJson(responseContent.toString(),type)
        } else {
            val jsonReader = JsonReader(responseContent?.charStream())
            httpResponse.result = Gson().fromJson<T>(jsonReader, this.getType())
//            httpResponse.result= Gson().fromJson<T>(responseContent.toString(),T::class.java)
        }
        onSuccessRequest(flag, httpResponse)
    }

    fun getType(): ParameterizedType {
        var genType = javaClass.genericSuperclass as ParameterizedType
        var params = genType.actualTypeArguments
        return params[0] as ParameterizedType
    }
}


