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
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class ModEnchantmentTagsProvider extends TagsProvider<Enchantment> {

	public ModEnchantmentTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, Registries.ENCHANTMENT, lookupProvider, UniqueMagicMod.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {

		tag(EnchantmentTags.ARMOR_EXCLUSIVE)
        	.add(ArmorEnchantments.FREEZING_PROTECTION)
        	.add(ArmorEnchantments.LIGHTNING_PROTECTION)
        	.add(ArmorEnchantments.MAGIC_PROTECTION)
        	.add(ArmorEnchantments.SONIC_PROTECTION);

        tag(EnchantmentTags.DAMAGE_EXCLUSIVE)
	    	.add(WeaponEnchantments.ILLAGERS_BANE)
	    	.add(WeaponEnchantments.NETHER_SLAYER)
	    	.add(WeaponEnchantments.PILLAGING);

		tag(ModEnchantmentTags.XP_GAIN_EXCLUSIVE)
			.add(Enchantments.MENDING)
			.add(ArmorEnchantments.EXPLORATION);

        tag(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE)
	    	.add(WeaponEnchantments.BLIND)
	    	.add(WeaponEnchantments.CONFUSE)
	    	.add(WeaponEnchantments.CURSE_OF_SLOWNESS)
	    	.add(WeaponEnchantments.HARM)
	    	.add(WeaponEnchantments.LEVITATE)
	    	.add(WeaponEnchantments.POISON)
	    	.add(WeaponEnchantments.SLOW)
	    	.add(WeaponEnchantments.STARVE)
	    	.add(WeaponEnchantments.TEMPO_THEFT)
	    	.add(WeaponEnchantments.WEAKEN)
	    	.add(WeaponEnchantments.WITHERING);
        
	}
	
    @Override
    public String getName()
    {
        return "Unique Magic Enchantment Tags";
    }
}
