package net.ampa.FirstProject.block.custom;

import net.ampa.FirstProject.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class EnergyDetectorBlock extends Block {
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 5);

    public EnergyDetectorBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LEVEL, Integer.valueOf(0)));
    }

//    @Override
//    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {
//        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
//            BlockPos pos = blockPos.south();
//            BlockState blockState = level.getBlockState(pos);
//            Block block = blockState.getBlock();
//            if(block == ModBlocks.URANIUM_ORE.get()){
//                level.setBlock(blockPos, state.setValue(LEVEL, 5),3);
//            }
//            else if(block == Blocks.AIR){
//                level.setBlock(blockPos, state.setValue(LEVEL, 0),3);
//            }
//        }
//        return InteractionResult.SUCCESS;
//    }


    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        if(pFromPos.equals(pPos.south())){
            BlockPos pos = pPos.south();
            BlockState blockState = pLevel.getBlockState(pos);
            Block block = blockState.getBlock();
            if(block == ModBlocks.URANIUM_ORE.get()){
                pLevel.setBlock(pPos, pState.setValue(LEVEL, 5),3);
            }
            else if(block == Blocks.AIR){
                pLevel.setBlock(pPos, pState.setValue(LEVEL, 0),3);
            }

        }
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }
}
