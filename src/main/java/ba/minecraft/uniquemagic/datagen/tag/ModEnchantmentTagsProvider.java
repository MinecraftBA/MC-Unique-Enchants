package ba.minecraft.uniquemagic.datagen.tag;

import java.util.concurrent.CompletableFuture;

import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchantments;
import ba.minecraft.uniquemagic.common.tags.ModEnchantmentTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.world.item.enchantment.Enchantments;

public final class ModEnchantmentTagsProvider extends EnchantmentTagsProvider {

	public ModEnchantmentTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void addTags(Provider provider) {
        tag(ModEnchantmentTags.PROTECTION)
    	.add(Enchantments.PROJECTILE_PROTECTION)
    	.add(Enchantments.BLAST_PROTECTION)
    	.add(Enchantments.PROTECTION)
    	.add(Enchantments.FIRE_PROTECTION)
    	.add(ArmorEnchantments.FREEZING_PROTECTION)
    	.add(ArmorEnchantments.LIGHTNING_PROTECTION)
    	.add(ArmorEnchantments.MAGIC_PROTECTION);
	}
	
    @Override
    public String getName()
    {
        return "Unique Magic Enchantment Tags";
    }
}
