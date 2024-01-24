package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.base.ApplyEffectEnchantment;
import ba.minecraft.uniquemagic.common.mobeffects.HarmfulMobEffects;
import net.minecraft.world.effect.MobEffect;

public class StunEnchantment extends ApplyEffectEnchantment {

	public StunEnchantment() {
		super(Rarity.VERY_RARE);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public int getMinCost(int enchantmentLevel) {
		return 10 + 20 * (enchantmentLevel - 1);
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return getMinCost(enchantmentLevel) + 50;
	}

	@Override
	protected MobEffect getMobEffect() {
		return HarmfulMobEffects.STUNNED.get();
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return enchantmentLevel;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return enchantmentLevel * 3;
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
