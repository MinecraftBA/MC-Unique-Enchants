package ba.minecraft.uniquemagic.common.event.enchantments.tools;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.DiggerEnchants;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
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
		
		// Get level of enchantment on item.
		int enchantmentLevel = item.getEnchantmentLevel(DiggerEnchants.TIMBER.get());
		
		// IF: Enchantment level is not at least 1;
		if (enchantmentLevel < 1) {
			return;
		}

		// Get position of block that was hit.
		BlockPos blockPos = event.getPos();

		// Try chop log at the position.
		chopLog(serverLevel, blockPos, item);
	}
	
	private static void chopLog(ServerLevel level, BlockPos blockPos, ItemStack item) {

		// Get type of block that was hit.
		BlockState blockState = level.getBlockState(blockPos);
		
		// IF: Block was not of type of log (wood).
		if (!blockState.is(BlockTags.LOGS)) {
			return;
		}
		
		// Try resolve blockentity for block.
        BlockEntity blockEntity = blockState.hasBlockEntity() ? 
        		level.getBlockEntity(blockPos) : null;

        // Drop resources from block.
        Block.dropResources(blockState, level, blockPos, blockEntity, null, item);

        // Destroy the block without loot drops.
        level.destroyBlock(blockPos, false);

        // Mine nearby blocks.
		chopLog(level, blockPos.below(), item);
		chopLog(level, blockPos.above(), item);
		chopLog(level, blockPos.north(), item);
		chopLog(level, blockPos.south(), item);
		chopLog(level, blockPos.east(), item);
		chopLog(level, blockPos.west(), item);
	}
}