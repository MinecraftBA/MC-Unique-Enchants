package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ApplyAttackerEffectWeaponEnchantment;
import ba.minecraft.uniquemagic.common.mobeffects.BeneficialMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;

public class RampageEnchantment extends ApplyAttackerEffectWeaponEnchantment {
	
	public RampageEnchantment() {
		super(Rarity.VERY_RARE);
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
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
	protected Holder<MobEffect> getAttackerMobEffect() {
		return BeneficialMobEffects.RAMPAGING.getHolder().get();
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return UniqueMagicModConfig.RAMPAGE_BASE_DURATION * enchantmentLevel;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return UniqueMagicModConfig.RAMPAGE_BASE_CHANCE * enchantmentLevel;
	}
	
	@Override
	protected String getBaseName() {
		return "Rampage";
	}

	@Override
	protected boolean isInstant() {
		return false;
	}
}
