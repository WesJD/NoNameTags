package me.wes.nonametags;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = NoNameTags.MOD_ID, name = NoNameTags.MOD_NAME, version = NoNameTags.MOD_VERSION)
public class NoNameTags {

    public static final String MOD_ID = "nonametags";
    public static final String MOD_NAME = "No Name Tags";
    public static final String MOD_VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        final ModMetadata metadata = e.getModMetadata();
        metadata.authorList.add(ChatFormatting.BLUE + "WesJD");
        metadata.autogenerated = false;
        metadata.description = ChatFormatting.YELLOW + "Hides player name tags while in hide HUD mode (pressing the F1 key)";
        metadata.url = "http://github.com/WesJD";
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onHudRender(RenderLivingEvent.Specials.Pre e) {
        if(Minecraft.getMinecraft().gameSettings.hideGUI) e.setCanceled(true);
    }

}
