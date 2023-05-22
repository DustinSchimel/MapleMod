package net.xerphy.maplemod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xerphy.maplemod.MapleMod;

public class MapleItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MapleMod.MOD_ID);

    public static final RegistryObject<Item> PIG_TAIL = ITEMS.register("pig_tail",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SNAIL_SHELL = ITEMS.register("snail_shell",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
