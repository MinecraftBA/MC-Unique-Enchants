package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.weapon.base.ApplyEffectEnchantment;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class SlowEnchantment extends ApplyEffectEnchantment {
	
	public SlowEnchantment() {
		super(Rarity.UNCOMMON);
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
		return MobEffects.MOVEMENT_SLOWDOWN;
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return enchantmentLevel * 5;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return enchantmentLevel * 25;
	}

	@Override
	protected boolean isInstant() {
		return false;
	}
	
	@Override
	protected String getBaseName() {
		return "Weaken";
	}
}
