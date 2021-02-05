package cn.clp.common.configs

import cn.clp.common.utils.Https.config.RequestConfig
import cn.clp.common.utils.MMKVUtil

interface AppConfig {
    companion object {
        /**
         * 是否是正式包
         */
        const val IS_RELEASE = RequestConfig.IS_RELEASE
        val DEFAULT_ONLIE_SCHEME_API = "https://api.fb-joy.com"
        val DEFAULT_TEST_SCHEME_API = "http://119.3.227.184:8010"
        val SCHEME_API = if (IS_RELEASE) MMKVUtil.getKVString(MMKVUtil.SCHEME_API, DEFAULT_ONLIE_SCHEME_API) else DEFAULT_TEST_SCHEME_API


        /**
         * 登录
         */
        const val LOGIN_API = "/user/mobile/code/new"
    }
}