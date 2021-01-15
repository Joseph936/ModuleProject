package cn.clp.common.utils

import android.widget.Toast

class ToastUtil {
    companion object {
        private var context = GlobalContextUtil.newInstance().getContext()
        public fun ShowToast(content: String) {
            Toast.makeText(context, content, Toast.LENGTH_LONG).show()
        }
    }
}