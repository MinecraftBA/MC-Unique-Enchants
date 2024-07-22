package ba.minecraft.uniquemagic.common.events.enchantments.tools;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.ToolEnchantments;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class TimberEnchantmentEventHandler {

	@SubscribeEvent
	public static void onPlayerLeftClickBlock(final LeftClickBlock event) {

		// Get level where code is executing.
		Level level = event.getLevel();
		
		// IF: Code is executing on client side.
		if (level.isClientSide()) {
			return;
		}

		// Cast level to ServerLevel.
		ServerLevel serverLevel = (ServerLevel)level;

		// Get player that has hit the block.
		ServerPlayer player = (ServerPlayer)event.getEntity();

		// Get item in main hand.
		ItemStack item = player.getMainHandItem();
		
    	// Get reference to enchantment.
    	Holder<Enchantment> enchantment = ModEnchantmentHelper.getHolder(level, ToolEnchantments.TIMBER);

		// Get level of enchantment on item.
		int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantment, item);
		
		// IF: Enchantment level is not at least 1;
		if (enchantmentLevel < 1) {
			return;
		}

		// Get position of block that was hit.
		BlockPos blockPos = event.getPos();
		
		// A counter for how many blocks were broken.
		int depth = 0;
		
		// Try chop log at the position.
		chopLog(serverLevel, blockPos, item, true, depth);
	}
	
	private static void chopLog(ServerLevel level, BlockPos blockPos, ItemStack item, boolean isStartingHit, int depth) {
		
		// Get type of block that was hit.
		BlockState blockState = level.getBlockState(blockPos);
		
		// IF: Block was not of type of log (wood) or leaves.
		if (!blockState.is(BlockTags.LOGS) && !blockState.is(BlockTags.LEAVES)) {
			return;
		}
		
		// Try resolve blockentity for block.
        BlockEntity blockEntity = blockState.hasBlockEntity() ? 
        		level.getBlockEntity(blockPos) : null;

        // Drop resources from block.
        Block.dropResources(blockState, level, blockPos, blockEntity, null, item);

        // Destroy the block without loot drops.
        level.destroyBlock(blockPos, false);
        
        // Increases the counter for blocks broken.
        depth++;
        
		// IF: 128 blocks were broken.
        
		if(depth == UniqueMagicModConfig.TIMBER_MAX_DEPTH) {
			return;
		}

        // IF: It is not starting hit.
        if(!isStartingHit) {
        	// It is ok to chop branches that are hanging.
    		chopLog(level, blockPos.below(), item, false, depth);
        }
        
        // Mine nearby blocks.
		chopLog(level, blockPos.north(), item, false, depth);
		chopLog(level, blockPos.south(), item, false, depth);
		chopLog(level, blockPos.east(), item, false, depth);
		chopLog(level, blockPos.west(), item, false, depth);
		chopLog(level, blockPos.above(), item, false, depth);
		chopLog(level, blockPos.above().north(), item, false, depth);
		chopLog(level, blockPos.above().south(), item, false, depth);
		chopLog(level, blockPos.above().east(), item, false, depth);
		chopLog(level, blockPos.above().west(), item, false, depth);
	}
}