package net.ampa.FirstProject.datagen;

import net.ampa.FirstProject.FirstProject;
import net.ampa.FirstProject.block.ModBlocks;
import net.ampa.FirstProject.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstProject.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        this.tag(ModTags.Blocks.URANIUM_DETECTOR_VALUABLES).add(ModBlocks.URANIUM_ORE.get()).addTag(Tags.Blocks.ORES);
        this.tag(ModTags.Blocks.URANIUM_DETECTOR_VALUABLES)
                .add(ModBlocks.URANIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_URANIUM_ORE.get(),
                        ModBlocks.URANIUM_BLOCK.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.URANIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_URANIUM_ORE.get(),
                        ModBlocks.URANIUM_BLOCK.get(),
                        ModBlocks.MINER.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.URANIUM_ORE.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.URANIUM_BLOCK.get());


    }
}
