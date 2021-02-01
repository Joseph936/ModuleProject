package cn.clp.common.configs

import cn.clp.common.utils.Https.config.RequestConfig

interface AppConfig {
    companion object {
        /**
         * 是否是正式包
         */
        const val IS_RELEASE = RequestConfig.IS_RELEASE
    }
}