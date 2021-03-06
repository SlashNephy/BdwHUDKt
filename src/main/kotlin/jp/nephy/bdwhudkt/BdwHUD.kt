package jp.nephy.bdwhudkt

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.common.config.Configuration
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import java.io.File
import net.minecraftforge.fml.common.network.NetworkCheckHandler
import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import net.minecraftforge.fml.common.eventhandler.EventPriority
import net.minecraft.client.Minecraft
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@SideOnly(Side.CLIENT)
@Mod(modid = "jp.nephy.bdwhudkt", version = "1.0.0")
class BdwHUD {
    private val chatManager = ChatManager()

    private var lineDetectionProgress = 0
    private var tick = 0

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    fun onRender(event: TickEvent.RenderTickEvent) {
        this.tickUpdate()
        //this.mcObject.ingameGUI.getFontRenderer().drawStringWithShadow(event.toString() +"", 30, 10, 0xFFFFFF);
        //this.mcObject.ingameGUI.getFontRenderer().drawStringWithShadow(this.tick +"", 30, 20, 0xFFFFFF);
        if (chatManager.isPlayingBedwars()) {
            //this.upgradeStatus.draw(this.mcObject.ingameGUI.fontRenderer)
        }
    }
-
    private fun tickUpdate() {
        if (tick > 0) {
            tick--
        } else if (tick == 0) {
            lineDetectionProgress = 0
        }
    }

    @SubscribeEvent
    fun onClientChatReceived(event: ClientChatReceivedEvent) {
        chatManager.handle(event)
//        val regexWord: Array<String>
//        regexWord = if (! isPlayingBedwars) {
//            chatOnStartBedwars
//        } else {
//            upgradeStatus.handleChat(chat)
//            chatOnFinishBedwars
//        }
//
//        if (chat.contains(regexWord[lineDetectionProgress])) {
//            if (lineDetectionProgress == 0) {
//                tick = 60
//            }
//            this.lineDetectionProgress++
//            if (lineDetectionProgress >= regexWord.size) {
//                isPlayingBedwars = !this.isPlayingBedwars
//                lineDetectionProgress = 0
//                tick = 0
//            }
//        }
    }

    @NetworkCheckHandler
    fun netCheckHandler(mods: Map<String, String>, side: Side): Boolean {
        return true //! side.isClient
    }
}
