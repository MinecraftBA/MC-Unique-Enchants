package ba.minecraft.uniquemagic.datagen.tag;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchantments;
import ba.minecraft.uniquemagic.common.tags.ModEnchantmentTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class ModEnchantmentTagsProvider extends EnchantmentTagsProvider {

	public ModEnchantmentTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, FeatureFlagSet.of(FeatureFlags.VANILLA), UniqueMagicMod.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
        tag(ModEnchantmentTags.PROTECTION)
    	.add(Enchantments.PROJECTILE_PROTECTION)
    	.add(Enchantments.BLAST_PROTECTION)
    	.add(Enchantments.PROTECTION)
    	.add(Enchantments.FIRE_PROTECTION)
    	.add(ArmorEnchantments.FREEZING_PROTECTION.get())
    	.add(ArmorEnchantments.LIGHTNING_PROTECTION.get())
    	.add(ArmorEnchantments.MAGIC_PROTECTION.get());
	}
	
    @Override
    public String getName()
    {
        return "Unique Magic Enchantment Tags";
    }
}
