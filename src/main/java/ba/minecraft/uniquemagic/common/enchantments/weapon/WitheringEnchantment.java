package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ApplyTargetEffectWeaponEnchantment;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class WitheringEnchantment extends ApplyTargetEffectWeaponEnchantment {
	
	public WitheringEnchantment() {
		super(Rarity.RARE);
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
	protected Holder<MobEffect> getMobEffect() {
		return MobEffects.WITHER;
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return UniqueMagicModConfig.WITHERING_BASE_DURATION * enchantmentLevel;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return UniqueMagicModConfig.WITHERING_BASE_CHANCE * enchantmentLevel;
	}

	@Override
	protected boolean isInstant() {
		return false;
	}
	
	@Override
	protected String getBaseName() {
		return "Withering";
	}
}
