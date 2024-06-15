package ba.minecraft.uniquemagic.common.helpers;

import java.util.ArrayList;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import net.minecraft.world.effect.MobEffects;

public class ApplyEffectEnchantments {

	public static final ArrayList<ApplyEffectEnchantmentConfiguration> TARGET_CONFIGURATIONS;
	
	static {
		
		TARGET_CONFIGURATIONS = new ArrayList<ApplyEffectEnchantmentConfiguration>();

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.BLIND,
			MobEffects.BLINDNESS,
			false,
			() -> { return UniqueMagicModConfig.BLIND_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.BLIND_BASE_DURATION; }
		));

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.CONFUSE,
			MobEffects.CONFUSION,
			false,
			() -> { return UniqueMagicModConfig.CONFUSE_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.CONFUSE_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.HARM,
			MobEffects.HARM,
			false,
			() -> { return UniqueMagicModConfig.HARM_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.HARM_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.LEVITATE,
			MobEffects.LEVITATION,
			false,
			() -> { return UniqueMagicModConfig.LEVITATE_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.LEVITATE_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.POISON,
			MobEffects.POISON,
			false,
			() -> { return UniqueMagicModConfig.POISON_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.POISON_BASE_DURATION; }
		));

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.SLOW,
			MobEffects.MOVEMENT_SLOWDOWN,
			false,
			() -> { return UniqueMagicModConfig.SLOW_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.SLOW_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.STARVE,
			MobEffects.HUNGER,
			false,
			() -> { return UniqueMagicModConfig.STARVE_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.STARVE_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.WEAKEN,
			MobEffects.WEAKNESS,
			false,
			() -> { return UniqueMagicModConfig.WEAKEN_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.WEAKEN_BASE_DURATION; }
		));

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.WITHERING,
			MobEffects.WITHER,
			false,
			() -> { return UniqueMagicModConfig.WITHERING_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.WITHERING_BASE_DURATION; }
		));

	}
}
