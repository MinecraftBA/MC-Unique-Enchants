package ba.minecraft.uniquemagic.datagen.tag;

import java.util.concurrent.CompletableFuture;

import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchantments;
import ba.minecraft.uniquemagic.common.enchantments.BowEnchantments;
import ba.minecraft.uniquemagic.common.enchantments.ToolEnchantments;
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

		// Add all mod specific enchantments here.
	    tag(ModEnchantmentTags.UNIQUE_MAGIC)
	    	.add(ArmorEnchantments.EXPLORATION)
	        .add(ArmorEnchantments.FREEZING_PROTECTION)
	        .add(ArmorEnchantments.LIGHTNING_PROTECTION)
	        .add(ArmorEnchantments.MAGIC_PROTECTION)
	        .add(ArmorEnchantments.OMNIVORE)
	        .add(ArmorEnchantments.SONIC_PROTECTION)
	        .add(BowEnchantments.TRIGGER)
	        .add(ToolEnchantments.TIMBER)
	        .add(WeaponEnchantments.BLIND)
	        .add(WeaponEnchantments.CONFUSE)
	        .add(WeaponEnchantments.CURSE_OF_SLOWNESS)
	        .add(WeaponEnchantments.DISARM)
	        .add(WeaponEnchantments.EXECUTE)
	        .add(WeaponEnchantments.BONE_BREAKER)
	        .add(WeaponEnchantments.HARM)
	        .add(WeaponEnchantments.ILLAGERS_BANE)
	        .add(WeaponEnchantments.KENSEI)
	        .add(WeaponEnchantments.LEVITATE)
	        .add(WeaponEnchantments.LIFE_STEAL)
	        .add(WeaponEnchantments.NETHER_SLAYER)
	        .add(WeaponEnchantments.PILLAGING)
	        .add(WeaponEnchantments.POISON)
	        .add(WeaponEnchantments.RAMPAGE)
	        .add(WeaponEnchantments.SLOW)
	        .add(WeaponEnchantments.STARVE)
	        .add(WeaponEnchantments.STUN)
	        .add(WeaponEnchantments.TEMPO_THEFT)
	        .add(WeaponEnchantments.THUNDERING)
	        .add(WeaponEnchantments.WEAKEN)
	        .add(WeaponEnchantments.WITHERING);
		
	    tag(EnchantmentTags.IN_ENCHANTING_TABLE)
	    	.addTag(ModEnchantmentTags.UNIQUE_MAGIC);
	    
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
