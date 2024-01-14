package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.TwoEffectEnchantment;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class CurseOfSlownessEnchantment extends TwoEffectEnchantment{

	
	public CurseOfSlownessEnchantment() {
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
		return MobEffects.MOVEMENT_SPEED;
	}
	
	@Override
	protected MobEffect getAttackerMobEffect() {
		return MobEffects.MOVEMENT_SLOWDOWN;
	}

	@Override
	protected int getSecondsDuration(int enchantmentLevel) {
		return UniqueMagicModConfig.CURSE_OF_SLOWNESS_BASE_DURATION * 3;
	}

	@Override
	protected int getChance(int enchantmentLevel) {
		return UniqueMagicModConfig.CURSE_OF_SLOWNESS_BASE_CHANCE * 40;
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
