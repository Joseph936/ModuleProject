package cn.clp.common.utils.Https.response

import cn.clp.common.utils.Https.model.HttpResponse
import cn.clp.common.utils.LogUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Response

interface Callback : Convert {
    fun onStartRequest(flag: String)
    fun <T : Any> onSuccessRequest(flag: String, response: HttpResponse<T>)
    fun onErrorRequest(flag: String, hasNetWork: Boolean)

    override fun <T : Any> convertResponse(flag: String, response: Response) {
        var responseContent = response.body?.string()
        var httpResponse = HttpResponse<T>()
        var value = httpResponse.data
        LogUtil.i("Callback", "httpResponse:$responseContent")
        if (value is List<*>) {
            httpResponse.data = Gson().fromJson<T>(responseContent.toString(), object : TypeToken<T>() {}.type)
        } else {
            httpResponse.data = Gson().fromJson<T>(responseContent.toString(), HttpResponse::class.java)
        }
        onSuccessRequest(flag, httpResponse)
    }
}



