package cn.clp.baseproject.utils

import cn.clp.common.utils.Md5Util

class AppUtil {
    companion object {
        const val MD5_KEY = "yg4#dFJLuBQqp31L"
        fun createMd5Code(code: String): String? {
            var stringBuilder = StringBuilder()
            stringBuilder.append(code)

            var stamp = System.currentTimeMillis() / 1000
            var timeStamp = (stamp xor stamp / 1000000) * 2
            stringBuilder.append(timeStamp)
            stringBuilder.append(MD5_KEY)
            return Md5Util.MD5(stringBuilder.toString())
        }
    }
}