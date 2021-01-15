package cn.clp.common.utils

import com.tencent.mmkv.MMKV

class MMKVUtil {
    companion object {
        val USER_ACCOUNT: String = "user_account"
        val USER_PASSWORD: String = "user_password"
        val LOGIN_STATUS: String = "login_status"

        var kv: MMKV = MMKV.defaultMMKV()!!

        fun putKVString(key: String, value: String): Unit {
            kv.encode(key, value)
        }

        fun putKVBoolean(key: String, value: Boolean): Unit {
            kv.encode(key, value)
        }

        fun putKVInt(key: String, value: Int): Unit {
            kv.encode(key, value)
        }

        fun putKVLong(key: String, value: Long): Unit {
            kv.encode(key, value)
        }

        fun putKVDouble(key: String, value: Double): Unit {
            kv.encode(key, value)
        }

        fun putKVFloat(key: String, value: Float): Unit {
            kv.encode(key, value)
        }


        fun getKVString(key: String): String? {
            return kv.decodeString(key)
        }

        fun getKVString(key: String, defaultString: String): String? {
            return kv.decodeString(key, defaultString)
        }

        fun getKVBoolean(key: String, defaultBoolean: Boolean): Boolean {
          return  kv.decodeBool(key, defaultBoolean)
        }

        fun getKVBoolean(key: String): Boolean {
            return kv.decodeBool(key, false)
        }

        fun getKVInt(key: String, defaultInt: Int): Int {
            return kv.decodeInt(key, defaultInt)
        }

        fun getKVInt(key: String): Int {
            return kv.decodeInt(key)
        }

        fun getKVLong(key: String, defaultLong: Long): Long {
            return kv.decodeLong(key, defaultLong)
        }

        fun getKVLong(key: String): Long {
            return kv.decodeLong(key)
        }

        fun getKVDouble(key: String, defaultDouble: Double): Double {
            return kv.decodeDouble(key, defaultDouble)
        }

        fun getKVDouble(key: String): Double {
            return kv.decodeDouble(key)
        }

        fun getKVFloat(key: String, defaultFloat: Float): Float {
            return kv.decodeFloat(key, defaultFloat)
        }

        fun getKVFloat(key: String): Float {
            return kv.decodeFloat(key)
        }
    }
}