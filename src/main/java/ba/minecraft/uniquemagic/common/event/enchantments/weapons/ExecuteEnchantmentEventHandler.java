package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class ExecuteEnchantmentEventHandler {

	@SubscribeEvent
	public static void onLivingAttack(final LivingAttackEvent event) {
		
		// Get source of the damage.
		DamageSource damageSource = event.getSource();
		
		// Get reference to entity that caused the damage.
		Entity attacker = damageSource.getEntity();

		// IF: Attack was not done by entity.
		if (attacker == null) {
			return;
		}

		// Get reference to level where event has occurred.
		Level level = attacker.level();
		
		// IF: Code is executing on the client side.
		if (level.isClientSide()) {
			return;
		}

		// Cast level to server level.
		ServerLevel serverLevel = (ServerLevel)level;
		
		// IF: Attacker is not player.
		if(!(attacker instanceof ServerPlayer)) {
			return;
		}
		
		// Cast attacker to player.
		ServerPlayer player = (ServerPlayer)attacker;

		// Get attacker item in main hand.
		ItemStack attackerItem = player.getItemInHand(InteractionHand.MAIN_HAND);
		
		// IF: There is no weapon in main hand of attacker.
		if (attackerItem == null) {
			// Do nothing.
			return;
		}
		
    	// Get reference to enchantment.
    	Holder<Enchantment> enchantment = ModEnchantmentHelper.getHolder(level, WeaponEnchantments.EXECUTE);

		// Get level of disarm enchantment.
		int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantment, attackerItem);
		
		// IF: Enchantment was not found on weapon.
		if (enchantmentLevel < 1) {
			// Do nothing.
			return;
		}

		// Get reference to entity that was attacked.
		Entity target = event.getEntity();

		// Variable to hold head type.
		Item headType = null;

		// IF: Target is zombie piglin.
		if(headType == null && target.getClass() == Piglin.class) {
			headType = Items.PIGLIN_HEAD;
		}

		// IF: Target is zombie.
		if(headType == null && target.getClass() == Zombie.class) {
			headType = Items.ZOMBIE_HEAD;
		}
		
		//IF:Target is wither skeleton
		if(headType == null && target.getClass() == WitherSkeleton.class) {
			headType = Items.WITHER_SKELETON_SKULL;
		}
		
		// IF: Target was Skeleton.
		if(headType == null && target.getClass() == Skeleton.class) {
			headType = Items.SKELETON_SKULL;
		}
		
		//IF: Target is creeper
		if(headType == null && target.getClass() == Creeper.class) {
			headType = Items.CREEPER_HEAD;
		}
		
		//IF: Target is player
		if(headType == null && target instanceof Player) {
			headType = Items.PLAYER_HEAD;
		}

		// IF: Head type was not determined.
		if (headType == null) {
			return;
		}
		
		// Create random generator.
		RandomSource random = level.getRandom();
		
		// Calculate proc chance - % for every level of enchantment.
		int hitChance = enchantmentLevel * UniqueMagicModConfig.EXECUTE_BASE_CHANCE;
		
		// Get number between 0 and 99.
		int roll = random.nextInt(100);
		
		// IF: Apply on hit chance was missed.
		if (roll >= hitChance) {
			
			// Do nothing.
			return;
		}
		
		// Get reference to position of mob that was attacked.
		BlockPos targetPosition = target.blockPosition();
		
		// Crate head item stack.
		ItemStack head = new ItemStack(headType);

		// Create item entity for head.
		ItemEntity headEntity = new ItemEntity(serverLevel, targetPosition.getX(), targetPosition.getY(), targetPosition.getZ(), head);
		
		// Add it to the world.
		serverLevel.addFreshEntity(headEntity);
		
		// Kill the target
		target.kill();
	}
}
