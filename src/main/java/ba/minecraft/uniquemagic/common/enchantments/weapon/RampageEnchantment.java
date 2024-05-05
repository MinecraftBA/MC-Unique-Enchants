package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ApplyAttackerEffectWeaponEnchantment;
import ba.minecraft.uniquemagic.common.mobeffects.BeneficialMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.enchantment.Enchantment;

public class RampageEnchantment extends ApplyAttackerEffectWeaponEnchantment {
	
	public RampageEnchantment() {
		super(2, Enchantment.dynamicCost(5, 10), Enchantment.dynamicCost(25, 10), 4);
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
