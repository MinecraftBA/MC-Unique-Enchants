package ba.minecraft.uniquemagic.common.helpers;

import java.util.function.Supplier;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.enchantment.Enchantment;

public class ApplyEffectEnchantmentConfiguration {

	private ResourceKey<Enchantment> enchantmentKey;
	private Holder<MobEffect> mobEffectHolder;
	private Boolean isInstant;
	private Supplier<Integer> baseChanceSupplier;
	private Supplier<Integer> baseDurationSupplier;
	
	public ApplyEffectEnchantmentConfiguration(ResourceKey<Enchantment> enchantmentKey, Holder<MobEffect> mobEffectHolder, Boolean isInstant, Supplier<Integer> baseChanceSupplier, Supplier<Integer> baseDurationSupplier) {
		this.enchantmentKey = enchantmentKey;
		this.mobEffectHolder = mobEffectHolder;
		this.isInstant = isInstant;
		this.baseChanceSupplier = baseChanceSupplier;
		this.baseDurationSupplier = baseDurationSupplier;
	}
	
	public Holder<MobEffect> getMobEffectHolder() {
		return this.mobEffectHolder;
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
