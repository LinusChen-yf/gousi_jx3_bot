package top.timewl.config

import net.mamoe.mirai.console.data.ReadOnlyPluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object CommandConfig : ReadOnlyPluginConfig("Command") {

    @ValueDescription("daily alias")
    val daily by value(arrayOf("daily", "日常"))

    @ValueDescription("joke alias")
    val joke by value(arrayOf("joke", "骚话"))
}