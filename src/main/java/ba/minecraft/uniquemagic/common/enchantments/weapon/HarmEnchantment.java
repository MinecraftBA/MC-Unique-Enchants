package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.weapon.base.ApplyEffectEnchantment;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public final class HarmEnchantment extends ApplyEffectEnchantment {
	
	public HarmEnchantment() {
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
		return MobEffects.HARM;
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return 0;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return enchantmentLevel * 50;
	}

	@Override
	protected boolean isInstant() {
		return true;
	}

	@Override
	protected String getBaseName() {
		return "Harm";
	}
}

