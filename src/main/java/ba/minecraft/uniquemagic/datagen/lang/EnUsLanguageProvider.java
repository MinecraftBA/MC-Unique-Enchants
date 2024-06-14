package ba.minecraft.uniquemagic.datagen.lang;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.ToolEnchantments;
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

		addToolEnchantments();
		
	}
	
	private void add(ResourceKey<Enchantment> enchantment, String name) {

		ResourceLocation resourceLocation = enchantment.location();
		
		String key = "enchantment." + resourceLocation.getNamespace() + "." + resourceLocation.getPath();
		
		add(key, name);
	}

	private void addToolEnchantments() {

		add(ToolEnchantments.TIMBER, "Timber");

	}
}
