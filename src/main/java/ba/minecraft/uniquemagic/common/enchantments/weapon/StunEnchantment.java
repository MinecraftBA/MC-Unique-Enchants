package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ApplyTargetEffectWeaponEnchantment;
import ba.minecraft.uniquemagic.common.mobeffects.HarmfulMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.enchantment.Enchantment;

public class StunEnchantment extends ApplyTargetEffectWeaponEnchantment {

	public StunEnchantment() {
		super(2, Enchantment.dynamicCost(5, 10), Enchantment.dynamicCost(25, 10), 4);
	}

	@Override
	protected Holder<MobEffect> getMobEffect() {
		return HarmfulMobEffects.STUNNED.getHolder().get();
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return UniqueMagicModConfig.STUN_BASE_DURATION * enchantmentLevel;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return UniqueMagicModConfig.STUN_BASE_CHANCE * enchantmentLevel;
	}

	@Override
	protected boolean isInstant() {
		return false;
	}

	@Override
	protected String getBaseName() {
		return "Stun";
	}
}
