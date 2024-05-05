package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ApplyTwoEffectsWeaponEnchantment;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.enchantment.Enchantment;

public class CurseOfSlownessEnchantment extends ApplyTwoEffectsWeaponEnchantment{

	public CurseOfSlownessEnchantment() {
		super(2, Enchantment.dynamicCost(5, 10), Enchantment.dynamicCost(25, 10), 4);
	}

	@Override
	public boolean isCurse() {
		return true;
	}

	@Override
	protected Holder<MobEffect> getTargetMobEffect() {
		return MobEffects.MOVEMENT_SPEED;
	}
	
	@Override
	protected Holder<MobEffect> getAttackerMobEffect() {
		return MobEffects.MOVEMENT_SLOWDOWN;
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return UniqueMagicModConfig.CURSE_OF_SLOWNESS_BASE_DURATION * enchantmentLevel;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return UniqueMagicModConfig.CURSE_OF_SLOWNESS_BASE_CHANCE * enchantmentLevel;
	}

	@Override
	protected boolean isInstant() {
		return false;
	}
	
	@Override
	protected String getBaseName() {
		return "Curse Of Slowness";
	}
}
