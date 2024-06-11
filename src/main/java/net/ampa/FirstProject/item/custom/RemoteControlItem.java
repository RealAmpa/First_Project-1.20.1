package net.ampa.FirstProject.item.custom;

import net.ampa.FirstProject.block.ModBlocks;
import net.ampa.FirstProject.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class RemoteControlItem extends Item {
    public RemoteControlItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos pos = pContext.getClickedPos();
        ItemStack itemStack = pContext.getItemInHand();
        Connection(itemStack, pos);
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        int[] blockPosArray = pPlayer.getItemInHand(pUsedHand).getTag().getIntArray("blockPos");
        CompoundTag tag = pPlayer.getItemInHand(pUsedHand).getTag();
//        tag.getIntArray("blockPos");
        int[] blockPosArray = tag.getIntArray("blockPos");

        BlockPos linkedPos = new BlockPos(blockPosArray[0], blockPosArray[1], blockPosArray[2]);
        LivingEntity pEntity = null;
        if(!pLevel.isClientSide && pPlayer.getMainHandItem().is(ModItems.REMOTE_CONTROL.get())){
            if(isLandMine(pLevel, linkedPos)) {
                pLevel.removeBlock(linkedPos, false);
                PrimedTnt primedtnt = new PrimedTnt(pLevel, (double)linkedPos.getX() + 0.5D, (double)linkedPos.getY(), (double)linkedPos.getZ() + 0.5D, pEntity);
                primedtnt.setFuse(0);
                pLevel.addFreshEntity(primedtnt);
            }
        }

        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    private static boolean isLandMine(Level pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos).is(ModBlocks.LAND_MINE.get());
    }
    private static void Connection(ItemStack itemStack, BlockPos pos) {
        if (pos == null) {
            itemStack.removeTagKey("blockPos");;
            return;
        }

        CompoundTag tag = new CompoundTag();
        int[] blockPosArray = {pos.getX(), pos.getY(), pos.getZ()};
        tag.putIntArray("blockPos", blockPosArray);
        itemStack.setTag(tag);
    }
}
