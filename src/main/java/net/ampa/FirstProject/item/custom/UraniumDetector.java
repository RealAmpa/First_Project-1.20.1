package net.ampa.FirstProject.item.custom;

import net.ampa.FirstProject.block.ModBlocks;
import net.ampa.FirstProject.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UraniumDetector extends Item {
    public UraniumDetector(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide){
            Player player = pContext.getPlayer();
            Level level = pContext.getLevel();
            BlockPos blockpos = pContext.getClickedPos();
            Boolean b = false;

            for(int i = 0; i <= blockpos.getY() + 64; i++){
                BlockState state = level.getBlockState(blockpos.below(i));

                if(isBlockUranium(state))
                    b = true;
            }

            if(b)
                player.sendSystemMessage(Component.literal("You've found Uranium!"));
            else
                player.sendSystemMessage(Component.literal("Nothing to find over here!"));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.first_project.uranium_detector"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private boolean isBlockUranium(BlockState state) {
        return state.is(ModTags.Blocks.URANIUM_DETECTOR_VALUABLES);
    }
}
