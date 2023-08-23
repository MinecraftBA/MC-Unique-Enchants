package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.enchantments.weapon.PoisonEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.StarveEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.WeakenEnchantment;
import ba.minecraft.uniquemagic.common.core.UniqueEnchantsMod;
import ba.minecraft.uniquemagic.common.enchantments.weapon.BlindEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.HarmEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.LevitateEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.LifeStealEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WeaponEnchants {

	public static final DeferredRegister<Enchantment> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UniqueEnchantsMod.MODID);
		
	public static final RegistryObject<Enchantment> LEVITATE = 
			REGISTRY.register("levitate",  () -> new LevitateEnchantment());
	
	public static final RegistryObject<Enchantment> POISON = 
			REGISTRY.register("poison",  () -> new PoisonEnchantment());
	
	public static final RegistryObject<Enchantment> STARVE = 
			REGISTRY.register("starve",  () -> new StarveEnchantment());
	
	public static final RegistryObject<Enchantment> WEAKEN = 
			REGISTRY.register("weaken",  () -> new WeakenEnchantment());
	
	public static final RegistryObject<Enchantment> LIFE_STEAL = 
			REGISTRY.register("life_steal",  () -> new LifeStealEnchantment());
	
	public static final RegistryObject<Enchantment> HARM = 
			REGISTRY.register("harm",  () -> new HarmEnchantment());
	
	public static final RegistryObject<Enchantment> BLIND = 
			REGISTRY.register("blind",  () -> new BlindEnchantment());
	
}
