package cn.clp.common.utils

import android.content.Context
import android.os.Build
import android.provider.Settings

class DeviceUtil {
    companion object {
        fun getDeviceName(): String {
            var device = Build.MODEL
            if (device == null) {
                return ""
            } else {
                var value = Build.MODEL
                for (key: Char in value) {
                    if ((key <= '\u001f' && key != '\t') || key >= '\u007f') {
                        value = value.replace(key, ' ')
                    }
                }
                return value
            }
        }


        fun getUniqueId(): String? {
            var context = GlobalContextUtil.newInstance().getContext()
            var androidId = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
            var id = androidId + Build.SERIAL
            return Md5Util.MD5(id)
        }
    }
}