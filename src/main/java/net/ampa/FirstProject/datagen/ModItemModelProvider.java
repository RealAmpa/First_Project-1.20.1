package net.ampa.FirstProject.datagen;

import net.ampa.FirstProject.FirstProject;
import net.ampa.FirstProject.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstProject.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_URANIUM);
        simpleItem(ModItems.URANIUM_INGOT);
        simpleItem(ModItems.URANIUM_DETECTOR);
        simpleItem(ModItems.URANIUM_REPLACER);
        simpleItem(ModItems.REPLACER);
        simpleItem(ModItems.DIESEL_BUCKET);
        simpleItem(ModItems.REMOTE_CONTROL);

    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FirstProject.MOD_ID,"item/" + item.getId().getPath()));
    }
}
