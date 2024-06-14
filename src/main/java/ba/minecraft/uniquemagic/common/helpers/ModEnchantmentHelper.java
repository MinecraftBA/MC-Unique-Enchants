package ba.minecraft.uniquemagic.common.helpers;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

public final class ModEnchantmentHelper {

	public static boolean is(ResourceKey<Enchantment> enchantment, TagKey<Enchantment> tag) {

		Reference<Enchantment> holder = enchantment.builtInRegistryHolder();
		
		// Check if enchantment is tagged.
		return holder.is(tag);
	}
	
    public static ResourceKey<Enchantment> createResourceKey(String path) {
        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(UniqueMagicMod.MODID, path));
    }
    
    public static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> enchantment, Enchantment.Builder builder) {
        context.register(enchantment, builder.build(enchantment.location()));
    }
    
    public static Holder<Enchantment> getHolder(Level level, ResourceKey<Enchantment> enchantment) {
    	return level.holderLookup(enchantment.registryKey()).getOrThrow(enchantment);
    }
}
