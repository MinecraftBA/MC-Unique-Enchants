package ba.minecraft.uniquemagic.datagen.tag;

import java.util.concurrent.CompletableFuture;

import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchantments;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import ba.minecraft.uniquemagic.common.tags.ModEnchantmentTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;

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
		
		tag(ModEnchantmentTags.XP_GAIN_EXCLUSIVE)
			.add(Enchantments.MENDING)
			.add(ArmorEnchantments.EXPLORATION);
		
        tag(EnchantmentTags.DAMAGE_EXCLUSIVE)
        	.add(WeaponEnchantments.ILLAGERS_BANE)
        	.add(WeaponEnchantments.NETHER_SLAYER)
        	.add(WeaponEnchantments.PILLAGING);
	}
	
    @Override
    public String getName()
    {
        return "Unique Magic Enchantment Tags";
    }
}
