package cn.clp.common.utils.Https.model

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.File
import java.util.LinkedHashMap

/**
 * 公共请求参数
 */
class HttpParams {
    companion object {
        val MEDIA_TYPE_PLAIN = "text/plain;charset=utf-8".toMediaTypeOrNull()
        val MEDIA_TYPE_JSON = "application/json;charset=utf-8".toMediaTypeOrNull()
        val MEDIA_TYPE_STREAM = "application/octet-stream".toMediaTypeOrNull()
    }

    private var urlParamsMap: LinkedHashMap<String, String>? = null
    private var fileParamsMap: LinkedHashMap<String, List<FileWrapper>>? = null

    init {
        urlParamsMap = LinkedHashMap()
        fileParamsMap = LinkedHashMap()
    }

    fun put(key: String, value: String) {
        urlParamsMap?.put(key, value)
    }

    fun putAll(urlParamsMap: LinkedHashMap<String, String>) {
        this.urlParamsMap = urlParamsMap
    }

    fun getUrlParams(): LinkedHashMap<String, String>? {
        return urlParamsMap
    }

    fun put(key: String, value: FileWrapper) {
        var fileWrapperFiles = ArrayList<FileWrapper>()
        fileWrapperFiles.add(value)
        fileParamsMap?.put(key, fileWrapperFiles)
    }

    fun put(key: String, value: List<FileWrapper>) {
        fileParamsMap?.put(key, value)
    }

    fun putAllFile(fileParamsMap: LinkedHashMap<String, List<FileWrapper>>) {
        this.fileParamsMap = fileParamsMap
    }

    fun getFileParams(): LinkedHashMap<String, List<FileWrapper>>? {
        return fileParamsMap
    }

    fun remove(key: String) {
        urlParamsMap?.remove(key)
    }

    fun removeFile(key: String) {
        fileParamsMap?.remove(key)
    }

    //    @Parcelize
    class FileWrapper {
        var file: File? = null
        var fileName: String? = null
        var contentType: MediaType? = null
        var fileSize: Long? = null

        override fun toString(): String {
            return "FileWrapper(file=$file, fileName=$fileName, contentType=$contentType, fileSize=$fileSize)"
        }


    }
}