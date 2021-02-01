package cn.clp.common.utils.Https.response

import okhttp3.Response

interface Convert {
    fun convertResponse(flag: String, response: Response)
}