package ba.minecraft.uniqueenchants.common.enchantments.weapon;

import ba.minecraft.uniqueenchants.common.enchantments.weapon.base.ApplyEffectEnchant;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.enchantment.Enchantment.Rarity;

public class LevitateEnchantment extends ApplyEffectEnchant {
	
	public LevitateEnchantment() {
		super(Rarity.RARE);
	}
	
	public int getMaxLevel() {
		return 2;
	}
	
	public int getMinCost(int enchantmentLevel) {
		return 25;
	}

	public int getMaxCost(int enchantmentLevel) {
		return getMinCost(enchantmentLevel) + 50;
	}

	protected MobEffect getMobEffect() {
		return MobEffects.LEVITATION;
	}

	protected int getSecondsDuration(int enchantmentLevel) {
		return enchantmentLevel * 5;
	}

	protected int getChance(int enchantmentLevel) {
		return enchantmentLevel * 10;
	}

}
