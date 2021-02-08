package cn.clp.common.utils.Https.model

class HttpResponse<T : Any> {
    var data: T? = null
    var meta: MetaEntry? = null

    var isConnectNetWork = false
    class MetaEntry {
        var message: String? = null
        var code: String? = null
        override fun toString(): String {
            return "MetaEntry(message=$message, code=$code)"
        }
    }

    override fun toString(): String {
        return "BaseResultEntity(meta=$meta)"
    }
}