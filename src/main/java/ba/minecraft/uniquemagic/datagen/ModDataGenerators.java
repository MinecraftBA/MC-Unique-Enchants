package ba.minecraft.uniquemagic.datagen;

import ba.minecraft.uniquemagic.common.core.UniqueEnchantsMod;
import ba.minecraft.uniquemagic.datagen.lang.EnUsLanguageProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueEnchantsMod.MODID, bus = Bus.MOD)
public final class ModDataGenerators {

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		
		// Get reference to running instance of data generator.
		DataGenerator dataGen = event.getGenerator();
		
		// Language providers
		dataGen.addProvider(event.includeClient(), new EnUsLanguageProvider(dataGen));
	}
}
