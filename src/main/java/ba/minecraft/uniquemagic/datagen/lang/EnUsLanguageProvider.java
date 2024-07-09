package ba.minecraft.uniquemagic.datagen.lang;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchantments;
import ba.minecraft.uniquemagic.common.enchantments.BowEnchantments;
import ba.minecraft.uniquemagic.common.enchantments.ToolEnchantments;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.data.LanguageProvider;

public final class EnUsLanguageProvider extends LanguageProvider {

	public EnUsLanguageProvider(PackOutput packOutput) {
		super(packOutput, UniqueMagicMod.MODID, "en_us");
	}
	
	@Override
	protected void addTranslations() {

		addArmorEnchantments();
		addBowEnchantments();
		addToolEnchantments();
		addWeaponEnchantments();
		
	}


	private void add(ResourceKey<Enchantment> enchantment, String name) {

		ResourceLocation resourceLocation = enchantment.location();
		
		String key = "enchantment." + resourceLocation.getNamespace() + "." + resourceLocation.getPath();
		
		add(key, name);
	}
	
	private void addArmorEnchantments() {

		add(ArmorEnchantments.EXPLORATION, "Exploration");
		add(ArmorEnchantments.OMNIVORE, "Omnivore");

		add(ArmorEnchantments.FREEZING_PROTECTION, "Freezing Protection");
		add(ArmorEnchantments.LIGHTNING_PROTECTION, "Lightning Protection");
		add(ArmorEnchantments.MAGIC_PROTECTION, "Magic Protection");
		add(ArmorEnchantments.SONIC_PROTECTION, "Sonic Protection");

	}
	
	private void addBowEnchantments() {

		add(BowEnchantments.TRIGGER, "Trigger");

	}

	private void addToolEnchantments() {

		add(ToolEnchantments.TIMBER, "Timber");

	}

	private void addWeaponEnchantments() {

		add(WeaponEnchantments.DISARM, "Disarm");
		add(WeaponEnchantments.EXECUTE, "Execute");
		add(WeaponEnchantments.KENSEI, "Kensei");
		add(WeaponEnchantments.LIFE_STEAL, "Life Steal");
		add(WeaponEnchantments.STUN, "Stun");
		add(WeaponEnchantments.THUNDERING, "Thundering");

		add(WeaponEnchantments.ILLAGERS_BANE, "Illager's Bane");
		add(WeaponEnchantments.NETHER_SLAYER, "Nether Slayer");
		add(WeaponEnchantments.PILLAGING, "Pillaging");

		add(WeaponEnchantments.BLIND, "Blind");
		add(WeaponEnchantments.CONFUSE, "Confuse");
		add(WeaponEnchantments.HARM, "Harm");
		add(WeaponEnchantments.LEVITATE, "Levitate");
		add(WeaponEnchantments.POISON, "Poison");
		add(WeaponEnchantments.SLOW, "Slow");
		add(WeaponEnchantments.STARVE, "Starve");
		add(WeaponEnchantments.WEAKEN, "Weaken");
		add(WeaponEnchantments.WITHERING, "Withering");

		add(WeaponEnchantments.RAMPAGE, "Rampage");

		add(WeaponEnchantments.CURSE_OF_SLOWNESS, "Curse of Slowness");

		add(WeaponEnchantments.TEMPO_THEFT, "Tempo Theft");

	}
}
