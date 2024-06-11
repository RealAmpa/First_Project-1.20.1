package net.ampa.FirstProject.item;

import net.ampa.FirstProject.FirstProject;
import net.ampa.FirstProject.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstProject.MOD_ID);
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            () -> new Item(new Item.Properties().food(ModFoods.EDIBLE_URANIUM)));
    public static final RegistryObject<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            () -> new Item(new Item.Properties().food(ModFoods.EDIBLE_URANIUM)));
    public static final RegistryObject<Item> URANIUM_DETECTOR = ITEMS.register("uranium_detector",
            () -> new UraniumDetector(new Item.Properties()));
    public static final RegistryObject<Item> REPLACER = ITEMS.register("replacer",
            () -> new Replacer(new Item.Properties()));
    public static final RegistryObject<Item> URANIUM_REPLACER = ITEMS.register("uranium_replacer",
            () -> new UraniumReplacer(new Item.Properties()));
    public static final RegistryObject<Item> REMOTE_CONTROL = ITEMS.register("remote_control",
            () -> new RemoteControlItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DIESEL_BUCKET = ITEMS.register("diesel_bucket",
            () -> new FuelItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1), 2000));
    public static final RegistryObject<Item> SOUL_SWORD = ITEMS.register("soul_sword",
            () -> new SoulSwordItem(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
