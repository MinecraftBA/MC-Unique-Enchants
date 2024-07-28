package ba.minecraft.uniquemagic.common.events.enchantments.weapons;

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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class ThunderingEnchantmentEventHandler {

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

		// IF: Attacker was not a living entity.
		if(!(attacker instanceof LivingEntity)) {
			return;
		}
		
		// Cast attacker to living entity.
		LivingEntity livingAttacker = (LivingEntity)attacker;

		ServerPlayer player = null;
		
		// IF: Attacker is player.
		if(livingAttacker instanceof ServerPlayer) {
			player = (ServerPlayer)livingAttacker;
		}
		
		// Get attacker item in main hand.
		ItemStack attackerItem = livingAttacker.getItemInHand(InteractionHand.MAIN_HAND);
		
		// IF: There is no weapon in main hand of attacker.
		if(attackerItem == null) {
			// Do nothing.
			return;
		}
		
    	// Get reference to enchantment.
    	Holder<Enchantment> enchantment = ModEnchantmentHelper.getHolder(level, WeaponEnchantments.THUNDERING);

		// Get level of disarm enchantment.
		int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantment, attackerItem);
		
		// IF: Enchantment was not found on weapon.
		if (enchantmentLevel < 1) {
			// Do nothing.
			return;
		}

		// Get reference to entity that was attacked.
		Entity target = event.getEntity();

		// Create random generator.
		RandomSource random = level.getRandom();
		
		// Calculate proc chance - % for every level of enchantment.
		int hitChance = enchantmentLevel * UniqueMagicModConfig.THUNDERING_BASE_CHANCE;
		
		// Get number between 0 and 99.
		int roll = random.nextInt(100);
		
		// IF: Apply on hit chance was missed.
		if (roll >= hitChance) {
			
			// Do nothing.
			return;
		}
		
		// Get reference to position of mob that was attacked.
		BlockPos targetPosition = target.blockPosition();
		
		// Spawn lightning bolt at mob's location.
		EntityType.LIGHTNING_BOLT.spawn(serverLevel, null, player, targetPosition, MobSpawnType.TRIGGERED, true, true);

	}
}
