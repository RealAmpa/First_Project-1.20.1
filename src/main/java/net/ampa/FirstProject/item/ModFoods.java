package net.ampa.FirstProject.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties EDIBLE_URANIUM = new FoodProperties.Builder().nutrition(4).saturationMod(0.2f)
            .effect(new MobEffectInstance(MobEffects.POISON, 1200, 1), 1.0F).effect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 1.0F).build();
}
