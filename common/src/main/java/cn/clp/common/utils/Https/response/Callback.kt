package cn.clp.common.utils.Https.response

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import okhttp3.Response
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

interface Callback : Convert {
    fun onStartRequest(flag: String)
    fun <T : Any> onSuccessRequest(flag: String, response: HttpResponse<T>)
    fun onErrorRequest(flag: String, hasNetWork: Boolean)
    override fun <T : Any> convertResponse(flag: String, response: Response) {
        var responseContent = response.body
        Log.i("responseContent", responseContent.toString())
//        var httpResponse = HttpResponse<T>()
//        var value = httpResponse.result
//        val jsonReader = JsonReader(responseContent?.charStream())
//        if (value is List<*>) {
////            val type: Type = object : TypeToken<T>() {}.type
////            httpResponse.result = Gson().fromJson<T>(responseContent,  object :TypeToken<T>() {}.type)
//            httpResponse.result = Gson().fromJson<T>(jsonReader, object : TypeToken<T>() {}.type)
//        } else {
//            httpResponse.result = Gson().fromJson<T>(jsonReader, value?.javaClass)
////            httpResponse.result = Gson().fromJson<T>(jsonReader,T::class.java)
//        }
//        onSuccessRequest(flag, httpResponse)
    }

//    fun getType(): ParameterizedType {
//        var genType = javaClass.genericSuperclass as ParameterizedType
//        var params = genType.actualTypeArguments
//        return params[0] as ParameterizedType
//    }
}


