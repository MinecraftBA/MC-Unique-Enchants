package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class KenseiEnchantmentEventHandler {
	
	@SubscribeEvent
	public static void onLivingHurt(final LivingHurtEvent event) {
		
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

		// IF: Attacker was not a living entity.
		if (!(attacker instanceof ServerPlayer)) {
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
    	Holder<Enchantment> enchantment = ModEnchantmentHelper.getHolder(level, WeaponEnchantments.KENSEI);

		// Get level of disarm enchantment.
		int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantment, attackerItem);
		
		// IF: Enchantment was not found on weapon.
		if (enchantmentLevel < 1) {
			// Do nothing.
			return;
		}

		// Get reference to xp that player has.
		int xp =  player.experienceLevel;
		
		// Get the amount of damage that was inflicted.
		float damageDealt = event.getAmount();
		
		// Calculate damage bonus from enchantment.
		float bonus = damageDealt * (xp * (UniqueMagicModConfig.KENSEI_BASE_RATIO / (float)100) * enchantmentLevel);
		
		// Increase damage dealt for bonus.
		damageDealt += bonus;
		
		// Set damage to be dealt on the event.
		event.setAmount(damageDealt);
	}

}
