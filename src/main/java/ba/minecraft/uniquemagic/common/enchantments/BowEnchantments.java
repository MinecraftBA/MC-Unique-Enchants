package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.bow.TriggerEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BowEnchantments {

	public static final DeferredRegister<Enchantment> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UniqueMagicMod.MODID);
		
	public static final RegistryObject<Enchantment> TRIGGER = 
			REGISTRY.register("trigger",  () -> new TriggerEnchantment());
	
}

