package cn.clp.common.utils

import android.widget.Toast

class ToastUtil {
    companion object {
        private var context = GlobalContextUtil.newInstance().getContext()
        private var toast: Toast? = null
        public fun ShowToast(content: String) {
            if (toast == null) {
                toast = Toast.makeText(context, content, Toast.LENGTH_SHORT)
            } else {
                toast!!.cancel()
                toast = Toast.makeText(context, content, Toast.LENGTH_SHORT)
            }
            toast!!.setText(content)
            toast!!.show()
        }
    }
}