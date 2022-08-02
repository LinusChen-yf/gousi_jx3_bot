package top.timewl.util

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import net.mamoe.mirai.utils.info
import okhttp3.*
import top.timewl.Jx3
import java.util.concurrent.TimeUnit

class RequestUtil {
    companion object {
        private val client = OkHttpClient().newBuilder().connectTimeout(60000, TimeUnit.MILLISECONDS)
            .readTimeout(60000, TimeUnit.MILLISECONDS)
        private var response: Response? = null

        fun request(
            method: Method,
            uri: String,
            body: RequestBody?,
            headers: Headers
        ): JsonElement? {

            /**
             * 进行请求转发
             */
            when (method) {
                Method.GET -> {
                    return httpObject(Request.Builder().url(uri).headers(headers).get().build())
                }
                Method.POST -> {
                    logger.info { "POST" }
                    return body?.let { Request.Builder().url(uri).headers(headers).post(it).build() }
                        ?.let { httpObject(it) }
                }
                Method.PUT -> {
                    return body?.let { Request.Builder().url(uri).headers(headers).put(it).build() }
                        ?.let { httpObject(it) }
                }
                Method.DEL -> {
                    return httpObject(Request.Builder().url(uri).headers(headers).delete(body).build())
                }
            }
        }


        /**
         * 发送http请求，返回数据（其中根据proxy是否配置加入代理机制）
         */
        private fun httpObject(request: Request): JsonElement? {
//            val host = Config.proxy.host
//            val port = Config.proxy.port
//
//
//            response = if (host.isBlank() || port == -1) {
//                client.build().newCall(request).execute()
//            } else {
//                val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress(host, port))
//                client.proxy(proxy).build().newCall(request).execute()
//            }

            response = client.build().newCall(request).execute()
            Jx3.logger.info { "respone" }
            if (response == null) {
                Jx3.logger.info { "respone is null" }
            }
            if (response!!.isSuccessful) {
                Jx3.logger.info { "respone 1" }
                return response!!.body?.string()?.let {
                    Json.parseToJsonElement(it)
                }
            }

            response!!.close()
            return null
        }

        /**
         * http的请求方式
         */
        enum class Method {
            GET, POST, PUT, DEL
        }
    }
}