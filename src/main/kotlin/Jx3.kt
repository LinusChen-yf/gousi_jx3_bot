package top.timewl

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.unregister
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info
import top.timewl.command.Daily

object Jx3 : KotlinPlugin(
    JvmPluginDescription(
        id = "top.timewl.jx3",
        name = "jx3",
        version = "0.1.0",
    ) {
        author("crash")
    }
) {
    internal lateinit var client: HttpClient

    override fun onEnable() {
        logger.info { "JX3 Plugin loaded" }
        client = HttpClient(OkHttp)
        Daily.register()
    }

    override fun onDisable() {
        super.onDisable()
        client.close()
        Daily.unregister()
    }

}