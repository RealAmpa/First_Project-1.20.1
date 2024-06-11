package net.ampa.FirstProject.block;

import net.ampa.FirstProject.FirstProject;
import net.ampa.FirstProject.block.custom.EnergyDetectorBlock;
import net.ampa.FirstProject.block.custom.LandMineBlock;
import net.ampa.FirstProject.block.custom.Miner;
import net.ampa.FirstProject.block.custom.ZirconLampBlock;
import net.ampa.FirstProject.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstProject.MOD_ID);

    public static final RegistryObject<Block> URANIUM_ORE = registerBlock("uranium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(5, 8)));
    public static final RegistryObject<Block> DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4.5f).requiresCorrectToolForDrops(), UniformInt.of(5, 8)));
    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("block_of_uranium",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4.5f).requiresCorrectToolForDrops(), UniformInt.of(5, 8)));
    public static final RegistryObject<Block> MINER = registerBlock("miner",
            () -> new Miner(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.STONE)));
    public static final RegistryObject<Block> LAND_MINE = registerBlock("land_mine",
            () -> new LandMineBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.STONE).noLootTable()));
    public static final RegistryObject<Block> ZIRCON_LAMP = registerBlock("zircon_lamp",
            () -> new ZirconLampBlock(BlockBehaviour.Properties.of()
                    .strength(6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(ZirconLampBlock.LIT) ? 15 : 0)));
    public static final RegistryObject<Block> ENERGY_DETECTOR = registerBlock("energy_detector",
            () -> new EnergyDetectorBlock(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}