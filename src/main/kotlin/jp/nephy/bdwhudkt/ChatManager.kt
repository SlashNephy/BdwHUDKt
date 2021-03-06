package jp.nephy.bdwhudkt

import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.ClientChatReceivedEvent

class ChatManager {
    lateinit var mcObject: Minecraft

    private var isPlayingBedwars = true //false

    private val startPatterns = arrayOf("Bedwars", "Protect your bed and destroy the enemy beds.", "Upgrade yourself and your team by collecting", "Iron, Gold, Emerald and Diamond from generators")
    private val finishPatterns = arrayOf("has won the game!", "Bedwars", "1st Killer -", "2nd Killer -", "3rd Killer -")
    private val upgrades = arrayOf(
            BdwUpgrade(
                arrayOf("Forge", "Forge +", "Forge ++", "Forge +++"),
                arrayOf(null, "purchased Iron Forge", "purchased Golden Forge", "purchased Emerald Forge")
            ),
            BdwUpgrade(
                arrayOf("Miner", "Miner +"),
                arrayOf(null, "purchased Maniac Miner")
            ),
            BdwUpgrade(
                arrayOf("Sharp", "Sharp +"),
                arrayOf(null, "purchased Sharpened Swords")
            ),
            BdwUpgrade(
                arrayOf("Protect", "Protect +", "Protect ++", "Protect +++"),
                arrayOf(null, "purchased Reinforce Armor")
            ),
            BdwUpgrade(
                arrayOf("Trap Off", "Trap Ready"),
                arrayOf("Your trap has been set off!", "purchased It's a trap!")
            ),
            BdwUpgrade(
                arrayOf("Fatigue", "Fatigue +"),
                arrayOf(null, "purchased Miner Fatigue")
            ),
            BdwUpgrade(
                arrayOf("Armor", "Armor +", "Armor ++"),
                arrayOf(null, "You purchased Permanent Chain", "You purchased Permanent Iron Armor", "You purchased Permanent Diamond Armor")
            )
    )

    fun isPlayingBedwars() = isPlayingBedwars

    private var detectionProgress = 0
    fun resetDetectionProgress() {
        detectionProgress = 0
    }

    fun handle(event: ClientChatReceivedEvent) {
        if (! ::mcObject.isInitialized) {
            mcObject = Minecraft.getMinecraft()
        }

        val message = event.message.unformattedText
        println(message)
    }

//    fun handleChat(chat: String) {
//        upgrades.forEach {
//            it.displayNames.indices.apply {
//                val pattern = it.patterns.getOrNull(this)
//                if (pattern != null) {
//                    if (chat.contains(pattern)) {
//                        if (upgrade.patterns.size == 2 && i == 1 && upgrade.displayNames.getOrNull(upgrade.status) != null) {
//                            upgrade.status = upgrade.status + 1
//                        } else {
//                            upgrade.status = i
//                        }
//                    }
//                }
//            }
//        }
//
//        for (upgrade in this.upgrades) {
//            for (i in upgrade.displayNames.indices) {
//                val pattern = upgrade.patterns.getOrNull(i)
//                if (pattern != null) {
//                    if (chat.contains(pattern)) {
//                        if (upgrade.patterns.size == 2 && i == 1 && upgrade.displayNames.getOrNull(upgrade.status) != null) {
//                            upgrade.status = upgrade.status + 1
//                        } else {
//                            upgrade.status = i
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    fun draw(upgrade: BedwarsUpgrade, level: Int) {
//        BedwarsUpgrade.values()
//        for (i in this.upgrades.indices) {
//            val color = if (level != 0) {
//                    0xFFFF00
//                } else {
//                    0x888888
//                }
//
//            try {
//                mcObject.fontRendererObj.drawStringWithShadow(this.upgrades[i].displayName, 1f, (1 + i * 8).toFloat(), color)
//            } catch (e: NullPointerException) {
//
//            }
//        }
//    }
}
