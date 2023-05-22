package net.xerphy.maplemod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.xerphy.maplemod.MapleMod;

@Mod.EventBusSubscriber(modid = MapleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MapleCreativeModeTabs
{
    public static CreativeModeTab MAPLE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        MAPLE_TAB = event.registerCreativeModeTab(new ResourceLocation(MapleMod.MOD_ID, "maple_tab"),
                builder -> builder.icon(() -> new ItemStack(MapleItems.SNAIL_SHELL.get()))
                        .title(Component.translatable("creativemodetab.maple_tab")));
    }
}
