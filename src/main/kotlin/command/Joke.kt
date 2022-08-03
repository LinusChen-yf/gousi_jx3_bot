package top.timewl.command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.console.command.descriptor.ExperimentalCommandDescriptors
import net.mamoe.mirai.console.util.ConsoleExperimentalApi
import top.timewl.Jx3
import top.timewl.config.CommandConfig
import top.timewl.util.getJoke

object Joke : SimpleCommand(
    Jx3,
    primaryName = "joke",
    secondaryNames = CommandConfig.joke
) {

    @ExperimentalCommandDescriptors
    @ConsoleExperimentalApi
    override val prefixOptional = true

    @Handler
    suspend fun CommandSender.handle() {

        val joke = getJoke()
        sendMessage(joke)

    }
}