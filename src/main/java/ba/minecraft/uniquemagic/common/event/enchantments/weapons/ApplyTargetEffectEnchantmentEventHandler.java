package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.helpers.ApplyEffectEnchantmentConfiguration;
import ba.minecraft.uniquemagic.common.helpers.ApplyEffectEnchantments;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class ApplyTargetEffectEnchantmentEventHandler {

	@SubscribeEvent
	public static void onAttackEntity(final LivingAttackEvent event) {
		
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
		if(!(attacker instanceof LivingEntity)) {
			return;
		}

		// Cast attacker to living entity.
		LivingEntity livingAttacker = (LivingEntity)attacker;

		// Get reference to entity that was attacked.
		Entity target = event.getEntity();

		// IF: Target is not a living entity.
		if(!(target instanceof LivingEntity)) {
			return;
		}

		// Cast target to living entity.
		LivingEntity livingTarget = (LivingEntity)target;

		// Get attacker item in main hand.
		ItemStack attackerItem = livingAttacker.getItemInHand(InteractionHand.MAIN_HAND);
		
		// IF: There is no weapon in main hand of attacker.
		if (attackerItem == null) {
			// Do nothing.
			return;
		}

		for(ApplyEffectEnchantmentConfiguration configuration : ApplyEffectEnchantments.TARGET_CONFIGURATIONS) {

	    	// Get reference to enchantment.
	    	Holder<Enchantment> enchantment = ModEnchantmentHelper.getHolder(level, configuration.getEnchantmentKey());

			// Get level of disarm enchantment.
			int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantment, attackerItem);
			
			// IF: Enchantment was not found on weapon.
			if (enchantmentLevel < 1) {

				// Proceed with next configuration.
				continue;
			}

			// IF: Target already has effect.
			if (livingTarget.hasEffect(configuration.getMobEffectHolder())){
				
				// Proceed with next configuration.
				continue;
			}

			// Create random generator.
			RandomSource random = level.getRandom();
			
			// Calculate proc chance - % for every level of enchantment.
			int hitChance = enchantmentLevel * configuration.getBaseChance();
			
			// Get number between 0 and 99.
			int roll = random.nextInt(100);
			
			// IF: Apply on hit chance was missed.
			if (roll >= hitChance) {
				
				// Do nothing.
				return;
			}

			// Calculate effect duration.
			int duration = configuration.isInstant() ? 
				1 : // Instant effects are applied on single tick and no more.
				configuration.getBaseDuration() * enchantmentLevel * 20; // Calculate duration of non-instant effect.

			// Create instance of effect.
			MobEffectInstance effect = new MobEffectInstance(configuration.getMobEffectHolder(), duration, enchantmentLevel - 1);

			// Apply effect to mob.
			livingTarget.addEffect(effect);
			
			// Do not process next enchantment.
			return;
		}

	}
}
