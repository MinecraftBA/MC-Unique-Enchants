package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ApplyTwoEffectsWeaponEnchantment;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class TempoTheftEnchantment extends ApplyTwoEffectsWeaponEnchantment {
	
	public TempoTheftEnchantment() {
		super(Rarity.VERY_RARE);
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
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
	protected MobEffect getTargetMobEffect() {
		return MobEffects.MOVEMENT_SLOWDOWN;
	}
	
	@Override
	protected MobEffect getAttackerMobEffect() {
		return MobEffects.MOVEMENT_SPEED;
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return UniqueMagicModConfig.TEMPO_THEFT_BASE_DURATION * enchantmentLevel;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return UniqueMagicModConfig.TEMPO_THEFT_BASE_CHANCE * enchantmentLevel;
	}

	@Override
	protected boolean isInstant() {
		return false;
	}
	
	@Override
	protected String getBaseName() {
		return "Tempo Theft";
	}
} 


