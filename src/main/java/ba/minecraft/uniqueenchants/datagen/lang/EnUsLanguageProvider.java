package ba.minecraft.uniqueenchants.datagen.lang;

import ba.minecraft.uniqueenchants.common.core.UniqueEnchantsMod;
import ba.minecraft.uniqueenchants.common.enchantments.WeaponEnchants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public final class EnUsLanguageProvider extends LanguageProvider {

	public EnUsLanguageProvider(DataGenerator dataGen) {
		super(dataGen, UniqueEnchantsMod.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {
		
		addEnchants();
	}
	
	private void addEnchants() {
		
		add(WeaponEnchants.LEVITATE.get(), "Levitate");
		add(WeaponEnchants.LIFE_STEAL.get(), "Life Steal");
	}
}
