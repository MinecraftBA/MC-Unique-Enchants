package ba.minecraft.uniquemagic.common.enchantments.base;

import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public abstract class ApplyEffectEnchantment extends ModEnchantment {
	
	protected ApplyEffectEnchantment(Rarity rarity) {
		super(rarity, EnchantmentCategory.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}
	
	/**
	 * Override to define which effect will be applied to target.
	 * @return Type of effect.
	 */
	protected abstract MobEffect getMobEffect();
	
	/**
	 * Override to define duration of the effect in seconds based on the enchantment level.
	 * @param enchantmentLevel - Level of the enchantment that is applied.
	 * @return Duration multiplier.
	 */
	/**
	 * @return
	 */
	protected abstract int getSecondsDuration(int enchantmentLevel);
	
	/**
	 * Override to define chance that the effect will proc based on the enchantment level.
	 * @param enchantmentLevel - Level of the enchantment that is applied.
	 * @return Chance multiplier.
	 */
	protected abstract int getChance(int enchantmentLevel);
	
	/**
	 * Override to define whether enchantment should apply effect that is instant (lasts 1 tick).
	 * @return True if it is instant.
	 */
	protected abstract boolean isInstant();
	
	@Override
	public void doPostAttack(LivingEntity attacker, Entity target, int enchantmentLevel) {
		
		// Get reference to a level.
		Level level = attacker.level();
		
		// IF: Code is executing on the client.
		if (level.isClientSide()) {
			return;
		}
		
		// IF: Entity is not living entity.
		if (!(target instanceof LivingEntity)) {
			return;
		}

		// Cast entity to living entity.
		LivingEntity livingTarget = (LivingEntity)target;
		
		// Get reference to effect that should be applied.
		MobEffect mobEffect = this.getMobEffect();
		
		// IF: Player already has effect.
		if (livingTarget.hasEffect(mobEffect)){
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
		if(this.isInstant()) {

			 // A single tick enchant duration will be applied.
			duration = 1;

			// Override to ensure that amplifier will be set to 1.
			//enchantmentLevel = 2;
			
		} else {

			// Calculate duration of the effect in seconds (1 sec = 20 ticks).
			duration = this.getSecondsDuration(enchantmentLevel) * 20;

		}

		// Create instance of effect.
		MobEffectInstance effect = new MobEffectInstance(mobEffect, duration, enchantmentLevel - 1);

		// Apply effect to mob.
		livingTarget.addEffect(effect);
	}
	
	

}
