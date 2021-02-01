package cn.clp.common.utils

import android.util.Log
import cn.clp.common.utils.Https.config.RequestConfig

class LogUtil {
    companion object {
        const val TAG = "CLP"
        fun v(message: String) {
            if (!RequestConfig.IS_RELEASE) {
                Log.v(TAG, message)
            }
        }

        fun d(message: String) {
            if (!RequestConfig.IS_RELEASE) {
                Log.d(TAG, message)
            }
        }

        fun i(message: String) {
            if (!RequestConfig.IS_RELEASE) {
                Log.i(TAG, message)
            }
        }

        fun w(message: String) {
            if (!RequestConfig.IS_RELEASE) {
                Log.w(TAG, message)
            }
        }

        fun e(message: String) {
            if (!RequestConfig.IS_RELEASE) {
                Log.e(TAG, message)
            }
        }
    }
}