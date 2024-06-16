package ba.minecraft.uniquemagic.common.helpers;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.enchantment.Enchantment;

public class ApplyEffectEnchantmentConfiguration {

	private ResourceKey<Enchantment> enchantmentKey;
	private Holder<MobEffect> attackerMobEffectHolder;
	private Holder<MobEffect> targetMobEffectHolder;
	private Boolean isInstant;
	private Supplier<Integer> baseChanceSupplier;
	private Supplier<Integer> baseDurationSupplier;
	
	public ApplyEffectEnchantmentConfiguration(ResourceKey<Enchantment> enchantmentKey, @Nullable Holder<MobEffect> attackerMobEffectHolder, @Nullable Holder<MobEffect> targetMobEffectHolder, Boolean isInstant, Supplier<Integer> baseChanceSupplier, Supplier<Integer> baseDurationSupplier) {
		this.enchantmentKey = enchantmentKey;
		this.targetMobEffectHolder = targetMobEffectHolder;
		this.attackerMobEffectHolder = attackerMobEffectHolder;
		this.isInstant = isInstant;
		this.baseChanceSupplier = baseChanceSupplier;
		this.baseDurationSupplier = baseDurationSupplier;
	}
	
	public Holder<MobEffect> getAttackerMobEffectHolder() {
		return this.attackerMobEffectHolder;
	}

	public Holder<MobEffect> getTargetMobEffectHolder() {
		return this.targetMobEffectHolder;
	}

	public Boolean isInstant() {
		return this.isInstant;
	}
	
	public ResourceKey<Enchantment> getEnchantmentKey(){
		return this.enchantmentKey;
	}
	
	public int getBaseChance() {
		return this.baseChanceSupplier.get();
	}
	
	public int getBaseDuration() {
		return this.baseDurationSupplier.get();
	}
}
