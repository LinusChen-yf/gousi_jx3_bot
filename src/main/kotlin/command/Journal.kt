package top.timewl.command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.console.command.descriptor.ExperimentalCommandDescriptors
import net.mamoe.mirai.console.util.ConsoleExperimentalApi
import top.timewl.Jx3
import top.timewl.config.CommandConfig
import top.timewl.util.getJournal

object Journal : SimpleCommand(
    Jx3,
    primaryName = "journal",
    secondaryNames = CommandConfig.journal
) {

    @ExperimentalCommandDescriptors
    @ConsoleExperimentalApi
    override val prefixOptional = true

    @Handler
    suspend fun CommandSender.handle() {

        val journal = getJournal()
        sendMessage(journal)

    }
}