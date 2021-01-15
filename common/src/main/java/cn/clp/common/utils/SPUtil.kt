package cn.clp.common.utils

import android.content.Context
import android.content.SharedPreferences

class SPUtil {
    companion object {
        val SP_NAME: String = "share_data";

        val USER_ACCOUNT: String = "user_account"
        val USER_PASSWORD: String = "user_password"
        val LOGIN_STATUS: String = "login_status"

        fun put(context: Context, key: String, value: Any) {
            var sp: SharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
            var editor: SharedPreferences.Editor = sp.edit()
            if (value is String) {
                editor.putString(key,value)
            }
        }
    }
}