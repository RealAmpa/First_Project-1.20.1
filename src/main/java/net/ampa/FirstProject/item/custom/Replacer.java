package net.ampa.FirstProject.item.custom;

import net.ampa.FirstProject.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
public class Replacer extends Item {
    public Replacer(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        BlockHitResult result = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.NONE);
        BlockPos lookPosition = result.getBlockPos();
        if(pPlayer.getMainHandItem().is(ModItems.REPLACER.get())){
            pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.AMETHYST_BLOCK_STEP, SoundSource.PLAYERS, 1.0F, 1.0F);
            pLevel.setBlock(lookPosition ,Blocks.DIAMOND_BLOCK.defaultBlockState() , 512);

        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}