package net.ampa.paimon_the_ruler.item;

import net.ampa.paimon_the_ruler.PaimonTheRuler;
import net.ampa.paimon_the_ruler.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PaimonTheRuler.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PAIMON_THE_RULER_CREATIVE_TAB = CREATIVE_MODE_TABS.register("paimon_the_ruler_creative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLOOD_BOTTLE.get()))
                    .title(Component.translatable("creativetab.paimon_the_ruler_creative_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLOOD_BOTTLE.get());
                        pOutput.accept(ModItems.HUMAN_FLESH.get());

                        pOutput.accept(Items.DIAMOND);

                        pOutput.accept(ModBlocks.BLOCK_OF_ROTTEN_FLESH.get());
                        pOutput.accept(ModBlocks.BLOCK_OF_LIVING_ROTTEN_FLESH.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
