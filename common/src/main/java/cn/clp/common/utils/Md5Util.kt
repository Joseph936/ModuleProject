package cn.clp.common.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and

class Md5Util {
    companion object {
        val digit = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
        fun MD5(source: String?): String? {
            return try {
//               val temp = (source ?: "").toByteArray(charset("UTF-8"))
                var temp = source?.toByteArray()
                return getMD5(temp)
            } catch (exception: Exception) {
                ""
            }
        }

        fun getMD5(source: ByteArray?): String? {
            return try {
                val result = StringBuilder()
                val digest = MessageDigest.getInstance("MD5")
                digest.update(source)
                val byteArray = digest.digest()
                for (b in byteArray) {
                    val ob = CharArray(2)
                    ob[0] = digit.get((b.toInt() ushr 4) and 0X0F)
                    ob[1] = digit.get((b and 0X0F).toInt())
                    result.append(String(ob))
                }
                result.toString()
            } catch (e: NoSuchAlgorithmException) {
                ""
            }
        }
    }
}