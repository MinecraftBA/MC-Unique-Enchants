package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ApplyTargetEffectWeaponEnchantment;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.enchantment.Enchantment;

public final class HarmEnchantment extends ApplyTargetEffectWeaponEnchantment {
	
	public HarmEnchantment() {
		super(5, Enchantment.dynamicCost(5, 10), Enchantment.dynamicCost(25, 10) , 2);
	}

	@Override
	protected Holder<MobEffect> getMobEffect() {
		return MobEffects.HARM;
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return UniqueMagicModConfig.HARM_BASE_DURATION * enchantmentLevel;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return UniqueMagicModConfig.HARM_BASE_CHANCE * enchantmentLevel;
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

