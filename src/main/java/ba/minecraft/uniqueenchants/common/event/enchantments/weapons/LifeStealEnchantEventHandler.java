package ba.minecraft.uniqueenchants.common.event.enchantments.weapons;

import ba.minecraft.uniqueenchants.common.core.UniqueEnchantsMod;
import ba.minecraft.uniqueenchants.common.enchantments.WeaponEnchants;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueEnchantsMod.MODID, bus = Bus.FORGE)
public final class LifeStealEnchantEventHandler {
	
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
		Level level = attacker.getLevel();
		
		// IF: Code is executing on the client side.
		if (level.isClientSide()) {
			return;
		}

		// IF: Attacker was not living entity.
		if(!(attacker instanceof LivingEntity)) {
			return;
		}
		
		// Cast entity to living entity.
		LivingEntity livingAttacker = (LivingEntity)attacker;

		// Get the amount of damage that was inflicted.
		float damageDealt = event.getAmount();

		// Get level of enchantment player has on equipped items.
		int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(WeaponEnchants.LIFE_STEAL.get(), livingAttacker);
				
		// IF: Enchantment level is not at least 1;
		if (enchantmentLevel < 1) {
			return;
		}
		
		// Calculate health to be restored based on the damage dealt and enchantment level.
		float healthRestored = damageDealt * (enchantmentLevel + 1) / 30;
		
		// Heal attacker.
		livingAttacker.heal(healthRestored);
	}
}
