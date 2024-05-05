package ba.minecraft.uniquemagic.common.enchantments.base;

import net.minecraft.core.Holder;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public abstract class ApplyAttackerEffectWeaponEnchantment extends ModEnchantment {

	protected ApplyAttackerEffectWeaponEnchantment(int weight, Cost minCost, Cost maxCost, int anvilCost) {
		super(ItemTags.WEAPON_ENCHANTABLE, weight, 5, minCost, maxCost, anvilCost, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	protected abstract Holder<MobEffect> getAttackerMobEffect();

	protected abstract int getSecondsDuration(int enchantmentLevel);

	protected abstract int getChance(int enchantmentLevel);

	protected abstract boolean isInstant();

	@Override
	public void doPostAttack(LivingEntity attacker, Entity target, int enchantmentLevel) {

		// Get reference to a level.
		Level level = attacker.level();

		// IF: Code is executing on the client.
		if (level.isClientSide()) {
			return;
		}

		// IF: Target is not living entity.
		if (!(target instanceof LivingEntity)) {
			return;
		}

		// Get reference to effect that should be applied.
		Holder<MobEffect> attackerMobEffect = this.getAttackerMobEffect();

		// IF: Attacker already has effect
		if (attacker.hasEffect(attackerMobEffect)) {
			return;
		}

		// Get reference to a random generator.
		RandomSource random = level.getRandom();

		// Calculate proc chance by multiplying enchantment
		int hitChance = this.getChance(enchantmentLevel);

		// Get number between 0 and 99.
		int roll = random.nextInt(100);

		// IF: Apply on hit chance was missed.
		if (roll >= hitChance) {
			return;
		}

		int duration;

		// IF: Enchant should apply instant effect.
		if (this.isInstant()) {

			// A single tick enchant duration will be applied.
			duration = 1;

		} else {

			// Calculate duration of the effect in seconds (1 sec = 20 ticks).
			duration = this.getSecondsDuration(enchantmentLevel) * 20;
		}

		// Create instance of effect.
		MobEffectInstance attackerMobEffectInstance = new MobEffectInstance(attackerMobEffect, duration,
				enchantmentLevel - 1);

		// Apply effect to attacker.
		attacker.addEffect(attackerMobEffectInstance);
	}
}
