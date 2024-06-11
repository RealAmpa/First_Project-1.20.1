package net.ampa.FirstProject.item.custom;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Collection;
import java.util.Optional;

public class SoulSwordItem extends SwordItem {
    public SoulSwordItem(Item.Properties pProperties) {
        super(new Tier() {
            @Override
            public int getUses() {
                return 500;
            }

            @Override
            public float getSpeed() {
                return 1000;
            }

            @Override
            public float getAttackDamageBonus() {
                return 5;
            }

            @Override
            public int getLevel() {
                return 2;
            }

            @Override
            public int getEnchantmentValue() {
                return 100;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.EMPTY;
            }
        }, 5, 2, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        CompoundTag tag = pStack.getOrCreateTag();
        tag.putInt("hitCount", tag.contains("hitCount", 3) ? tag.getInt("hitCount") + 1 : 1);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public HashMultimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        int extraDamage = stack.getTag() != null ? stack.getTag().getInt("hitCount") : 0;
        Multimap<Attribute, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);
        HashMultimap<Attribute, AttributeModifier> hashMultimap = HashMultimap.create();
        if (slot == EquipmentSlot.MAINHAND) {
            Collection<AttributeModifier> col = multimap.get(Attributes.ATTACK_DAMAGE);
            col.forEach(attributeModifier -> {
                if (attributeModifier.getOperation() == AttributeModifier.Operation.ADDITION) {
                    multimap.remove(Attributes.ATTACK_DAMAGE, attributeModifier);
                    multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 5 + extraDamage, AttributeModifier.Operation.ADDITION));
                    multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", 3, AttributeModifier.Operation.ADDITION));

                    hashMultimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 5 + extraDamage, AttributeModifier.Operation.ADDITION));
                    hashMultimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 3, AttributeModifier.Operation.ADDITION));
                }
                else {
                    multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 5 + extraDamage, AttributeModifier.Operation.ADDITION));
                    multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", 3, AttributeModifier.Operation.ADDITION));

                    hashMultimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 5 + extraDamage, AttributeModifier.Operation.ADDITION));
                    hashMultimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 3, AttributeModifier.Operation.ADDITION));
                }
            });
        }
        return hashMultimap;
    }
}
