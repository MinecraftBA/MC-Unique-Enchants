package ba.minecraft.uniquemagic.datagen.tag;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.tags.ModDamageTypeTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class ModDamageTypeTagsProvider extends DamageTypeTagsProvider {

	public ModDamageTypeTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, UniqueMagicMod.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
        tag(ModDamageTypeTags.MAGIC)
	    	.add(DamageTypes.MAGIC)
	    	.add(DamageTypes.INDIRECT_MAGIC);

        tag(ModDamageTypeTags.SONIC)
	    	.add(DamageTypes.SONIC_BOOM);
}

	@Override
	public String getName() {
		return "Unique Magic DamageType Tags";
	}

}
