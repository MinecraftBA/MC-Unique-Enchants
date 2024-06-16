package ba.minecraft.uniquemagic.datagen.tag;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchantments;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import ba.minecraft.uniquemagic.common.tags.ModEnchantmentTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class ModEnchantmentTagsProvider extends EnchantmentTagsProvider {

	public ModEnchantmentTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void addTags(Provider provider) {

		tag(EnchantmentTags.ARMOR_EXCLUSIVE)
        	.add(ArmorEnchantments.FREEZING_PROTECTION)
        	.add(ArmorEnchantments.LIGHTNING_PROTECTION)
        	.add(ArmorEnchantments.MAGIC_PROTECTION)
        	.add(ArmorEnchantments.SONIC_PROTECTION);

	}
	
    @Override
    public String getName()
    {
        return "Unique Magic Enchantment Tags";
    }
}
