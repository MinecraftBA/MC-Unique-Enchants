package ba.minecraft.uniquemagic.datagen;

import java.util.concurrent.CompletableFuture;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.datagen.tag.ModEntityTypeTagsProvider;
import ba.minecraft.uniquemagic.datagen.tag.ModDamageTypeTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.MOD)
public final class ModDataGenerators {

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {

		// Get reference to existing file helper.
		ExistingFileHelper exFileHelper = event.getExistingFileHelper();

		// Get reference to lookup provider.
		CompletableFuture<Provider> lookupProvider = event.getLookupProvider();

		// Get reference to running instance of data generator.
		DataGenerator dataGen = event.getGenerator();
		
		// Get reference to pack output.
		PackOutput packOutput = dataGen.getPackOutput();
		
		// Registration of entity type tags provider.
		dataGen.addProvider(event.includeServer(), new ModEntityTypeTagsProvider(packOutput, lookupProvider, exFileHelper));

		// Registration of damage type tags provider.
		dataGen.addProvider(event.includeServer(), new ModDamageTypeTagsProvider(packOutput, lookupProvider, exFileHelper));
	}
	
}
