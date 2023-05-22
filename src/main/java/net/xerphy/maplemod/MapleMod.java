package net.xerphy.maplemod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.xerphy.maplemod.block.MapleBlocks;
import net.xerphy.maplemod.item.MapleCreativeModeTabs;
import net.xerphy.maplemod.item.MapleItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MapleMod.MOD_ID)
public class MapleMod
{
    public static final String MOD_ID = "maplemod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MapleMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MapleItems.register(modEventBus);
        MapleBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(MapleItems.PIG_TAIL);
            event.accept(MapleItems.SNAIL_SHELL);
        }

        if (event.getTab() == MapleCreativeModeTabs.MAPLE_TAB)
        {
            event.accept(MapleItems.PIG_TAIL);
            event.accept(MapleItems.SNAIL_SHELL);

            event.accept(MapleBlocks.OMOK_TABLE_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS)
        {
            event.accept(MapleBlocks.OMOK_TABLE_BLOCK);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
