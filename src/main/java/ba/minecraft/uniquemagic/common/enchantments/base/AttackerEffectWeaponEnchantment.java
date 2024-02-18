package ba.minecraft.uniquemagic.common.enchantments.base;

import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public abstract class AttackerEffectWeaponEnchantment extends ModEnchantment {
	
	protected AttackerEffectWeaponEnchantment(Rarity rarity) {
		super(rarity, EnchantmentCategory.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}
	
	protected abstract MobEffect getAttackerMobEffect();
	
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
		
		// IF: Entity is not living entity.
		if (!(target instanceof LivingEntity)) {
			return;
		}
		
		
		// Get reference to effect that should be applied.
		MobEffect attackerMobEffect = this.getAttackerMobEffect();
		
		
		//IF: Attacker already has effect
		if (attacker.hasEffect(attackerMobEffect)){
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
	    MobEffectInstance attackerMobEffectInstance = new MobEffectInstance(attackerMobEffect, duration, enchantmentLevel - 1);

		// Apply effect to mob.
		attacker.addEffect(attackerMobEffectInstance);
	}
}
