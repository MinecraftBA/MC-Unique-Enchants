package ba.minecraft.uniquemagic.common.helpers;

import java.util.ArrayList;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import ba.minecraft.uniquemagic.common.mobeffects.BeneficialMobEffects;
import ba.minecraft.uniquemagic.common.mobeffects.HarmfulMobEffects;
import net.minecraft.world.effect.MobEffects;

public class ApplyEffectEnchantments {

	public static final ArrayList<ApplyEffectEnchantmentConfiguration> TARGET_CONFIGURATIONS;
	public static final ArrayList<ApplyEffectEnchantmentConfiguration> ATTACKER_CONFIGURATIONS;
	public static final ArrayList<ApplyEffectEnchantmentConfiguration> BOUND_CONFIGURATIONS;
	
	static {
		
		TARGET_CONFIGURATIONS = new ArrayList<ApplyEffectEnchantmentConfiguration>();

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.BLIND,
			null,
			MobEffects.BLINDNESS,
			false,
			() -> { return UniqueMagicModConfig.BLIND_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.BLIND_BASE_DURATION; }
		));

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.CONFUSE,
			null,
			MobEffects.CONFUSION,
			false,
			() -> { return UniqueMagicModConfig.CONFUSE_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.CONFUSE_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.HARM,
			null,
			MobEffects.HARM,
			false,
			() -> { return UniqueMagicModConfig.HARM_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.HARM_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.LEVITATE,
			null,
			MobEffects.LEVITATION,
			false,
			() -> { return UniqueMagicModConfig.LEVITATE_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.LEVITATE_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.POISON,
			null,
			MobEffects.POISON,
			false,
			() -> { return UniqueMagicModConfig.POISON_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.POISON_BASE_DURATION; }
		));

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.SLOW,
			null,
			MobEffects.MOVEMENT_SLOWDOWN,
			false,
			() -> { return UniqueMagicModConfig.SLOW_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.SLOW_BASE_DURATION; }
		));
		
		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.STARVE,
			null,
			MobEffects.HUNGER,
			false,
			() -> { return UniqueMagicModConfig.STARVE_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.STARVE_BASE_DURATION; }
		));

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.STUN,
			null,
			HarmfulMobEffects.STUNNED.getHolder().get(),
			false,
			() -> { return UniqueMagicModConfig.STUN_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.STUN_BASE_DURATION; }
		));

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.WEAKEN,
			null,
			MobEffects.WEAKNESS,
			false,
			() -> { return UniqueMagicModConfig.WEAKEN_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.WEAKEN_BASE_DURATION; }
		));

		TARGET_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.WITHERING,
			null,
			MobEffects.WITHER,
			false,
			() -> { return UniqueMagicModConfig.WITHERING_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.WITHERING_BASE_DURATION; }
		));
		
		ATTACKER_CONFIGURATIONS = new ArrayList<ApplyEffectEnchantmentConfiguration>();

		ATTACKER_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.RAMPAGE,
			BeneficialMobEffects.RAMPAGING.getHolder().get(),
			null,
			false,
			() -> { return UniqueMagicModConfig.RAMPAGE_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.RAMPAGE_BASE_DURATION; }
		));

		BOUND_CONFIGURATIONS = new ArrayList<ApplyEffectEnchantmentConfiguration>();

		BOUND_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.CURSE_OF_SLOWNESS,
			MobEffects.MOVEMENT_SLOWDOWN,
			MobEffects.MOVEMENT_SPEED,
			false,
			() -> { return UniqueMagicModConfig.CURSE_OF_SLOWNESS_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.CURSE_OF_SLOWNESS_BASE_DURATION; }
		));

		BOUND_CONFIGURATIONS.add(new ApplyEffectEnchantmentConfiguration(
			WeaponEnchantments.TEMPO_THEFT,
			MobEffects.MOVEMENT_SPEED,
			MobEffects.MOVEMENT_SLOWDOWN,
			false,
			() -> { return UniqueMagicModConfig.TEMPO_THEFT_BASE_CHANCE; },
			() -> { return UniqueMagicModConfig.TEMPO_THEFT_BASE_DURATION; }
		));

	}
}
