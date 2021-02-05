package cn.clp.common.utils.Https.response

import okhttp3.Response

interface Convert {
    fun <T:Any> convertResponse(flag: String, response: Response)
}