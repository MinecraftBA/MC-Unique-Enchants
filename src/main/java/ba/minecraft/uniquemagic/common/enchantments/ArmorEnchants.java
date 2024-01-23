package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.armor.OmnivoreEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.tool.TimberEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArmorEnchants {
	
	public static final DeferredRegister<Enchantment> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UniqueMagicMod.MODID);
	
	public static final RegistryObject<Enchantment> OMNIVORE = 
			REGISTRY.register("omnivore",  () -> new OmnivoreEnchantment());
}
