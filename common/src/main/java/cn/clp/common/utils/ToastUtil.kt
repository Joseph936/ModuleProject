package cn.clp.common.utils

import android.widget.Toast

class ToastUtil {
    companion object {
        private var context = GlobalContextUtil.newInstance().getContext()
        private var toast: Toast? = null
        fun showToast(content: String) {
            toast = if (toast == null) {
                Toast.makeText(context, content, Toast.LENGTH_SHORT)
            } else {
                toast!!.cancel()
                Toast.makeText(context, content, Toast.LENGTH_SHORT)
            }
            toast!!.setText(content)
            toast!!.show()
        }
    }
}