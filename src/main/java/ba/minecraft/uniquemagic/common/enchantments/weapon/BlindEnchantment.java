package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.weapon.base.ApplyEffectEnchant;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class BlindEnchantment  extends ApplyEffectEnchant {
	
	public BlindEnchantment() {
		super(Rarity.RARE);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
	
	@Override
	public int getMinCost(int enchantmentLevel) {
		return 25;
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return getMinCost(enchantmentLevel) + 50;
	}

	@Override
	protected MobEffect getMobEffect() {
		return MobEffects.BLINDNESS;
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return enchantmentLevel * 5;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return enchantmentLevel * 50;
	}

	@Override
	protected boolean isInstant() {
		return false;
	}
}
