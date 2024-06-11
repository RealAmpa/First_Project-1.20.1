package net.ampa.FirstProject.item;

import net.ampa.FirstProject.FirstProject;
import net.ampa.FirstProject.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstProject.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIRST_PROJECT_CREATIVE_TAB = CREATIVE_MODE_TABS.register("creativetab.first_project",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.URANIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.first_project_creative_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_URANIUM.get());
                        pOutput.accept(ModItems.URANIUM_INGOT.get());
                        pOutput.accept(ModItems.REPLACER.get());
                        pOutput.accept(ModItems.URANIUM_REPLACER.get());
                        pOutput.accept(ModItems.URANIUM_DETECTOR.get());
                        pOutput.accept(ModItems.DIESEL_BUCKET.get());
                        pOutput.accept(ModItems.REMOTE_CONTROL.get());
                        pOutput.accept(ModItems.SOUL_SWORD.get());


                        pOutput.accept(ModBlocks.URANIUM_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_URANIUM_ORE.get());
                        pOutput.accept(ModBlocks.URANIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.MINER.get());
                        pOutput.accept(ModBlocks.LAND_MINE.get());
                        pOutput.accept(ModBlocks.ZIRCON_LAMP.get());
                        pOutput.accept(ModBlocks.ENERGY_DETECTOR.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
