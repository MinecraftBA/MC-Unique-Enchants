package ba.minecraft.uniqueenchants.common.enchantments;

import ba.minecraft.uniqueenchants.common.core.UniqueEnchantsMod;
import ba.minecraft.uniqueenchants.common.enchantments.weapon.LevitateEnchantment;
import ba.minecraft.uniqueenchants.common.enchantments.weapon.LifeStealEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WeaponEnchants {

	public static final DeferredRegister<Enchantment> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UniqueEnchantsMod.MODID);
		
	public static final RegistryObject<Enchantment> LEVITATE = 
			REGISTRY.register("levitate",  () -> new LevitateEnchantment());
	
	public static final RegistryObject<Enchantment> LIFE_STEAL = 
			REGISTRY.register("life_steal",  () -> new LifeStealEnchantment());
	
}
