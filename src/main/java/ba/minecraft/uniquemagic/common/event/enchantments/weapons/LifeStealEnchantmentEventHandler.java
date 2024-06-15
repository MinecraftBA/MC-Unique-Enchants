package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class LifeStealEnchantmentEventHandler {
	
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

		// IF: Attacker was not player.
		if(!(attacker instanceof Player)) {
			return;
		}
		
		// Cast entity to player.
		Player player = (Player)attacker;

		// Get the amount of damage that was inflicted.
		float damageDealt = event.getAmount();

    	// Get reference to enchantment.
    	Holder<Enchantment> enchantment = ModEnchantmentHelper.getHolder(level, WeaponEnchantments.LIFE_STEAL);

		// Get level of enchantment player has on equipped items.
		int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(enchantment, player);
				
		// IF: Enchantment level is not at least 1;
		if (enchantmentLevel < 1) {
			return;
		}
		
		// Calculate health to be restored based on the damage dealt and enchantment level.
		float healthRestored = damageDealt * UniqueMagicModConfig.LIFE_STEAL_BASE_RATIO / 100;
		
		// Heal attacker.
		player.heal(healthRestored);
	}
}
