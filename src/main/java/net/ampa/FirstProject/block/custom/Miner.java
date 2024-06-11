package net.ampa.FirstProject.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Miner extends Block {
    public static final BooleanProperty IS_ON = BooleanProperty.create("is_on");
    public Miner(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(IS_ON, Boolean.valueOf(false)));
    }

//        if(pLevel.hasNeighborSignal(pPos))
//            pPlayer.sendSystemMessage(Component.literal("Got signal!"));

/*
    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos blockpos, RandomSource random) {
        System.out.println("tick tick!");
        BlockPos pos = blockpos.above();
        BlockState blockState = level.getBlockState(pos);
        Block block = blockState.getBlock();
        if(block == Blocks.DIAMOND_ORE)
        {
            System.out.println("shoot!");
        }
    }
 */

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND){
            pLevel.setBlock(pPos, pState.cycle(IS_ON), 3);
            if(!pState.getValue(IS_ON))
                pLevel.destroyBlock(pPos.above(), true);
            pLevel.playSound( null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1F, 1F);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.first_project.miner"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(IS_ON);
    }

}
