package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.armor.ExplorationEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.armor.FreezingProtectionEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.armor.LightningProtectionEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.armor.MagicProtectionEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.armor.OmnivoreEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.armor.SonicProtectionEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArmorEnchantments {
	
	public static final DeferredRegister<Enchantment> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UniqueMagicMod.MODID);
	
	public static final RegistryObject<Enchantment> OMNIVORE = 
			REGISTRY.register("omnivore",  () -> new OmnivoreEnchantment());

	public static final RegistryObject<Enchantment> LIGHTNING_PROTECTION = 
			REGISTRY.register("lightning_protection",  () -> new LightningProtectionEnchantment());

	public static final RegistryObject<Enchantment> FREEZING_PROTECTION = 
			REGISTRY.register("freezing_protection",  () -> new FreezingProtectionEnchantment());
	
	public static final RegistryObject<Enchantment> MAGIC_PROTECTION = 
			REGISTRY.register("magic_protection",  () -> new MagicProtectionEnchantment());
	
	public static final RegistryObject<Enchantment> SONIC_PROTECTION = 
			REGISTRY.register("sonic_protection",  () -> new SonicProtectionEnchantment());
	
	public static final RegistryObject<Enchantment> EXPLORATION = 
			REGISTRY.register("exploration",  () -> new ExplorationEnchantment());
}
