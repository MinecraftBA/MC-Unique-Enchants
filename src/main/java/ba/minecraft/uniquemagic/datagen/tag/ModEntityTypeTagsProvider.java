package ba.minecraft.uniquemagic.datagen.tag;

import java.util.concurrent.CompletableFuture;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.tags.ModEntityTypeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class ModEntityTypeTagsProvider extends EntityTypeTagsProvider
{
    public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, UniqueMagicMod.MODID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider lookupProvider)
    {
        tag(ModEntityTypeTags.NETHER_MOBS)
        	.add(EntityType.BLAZE)
        	.add(EntityType.MAGMA_CUBE)
        	.add(EntityType.PIGLIN)
        	.add(EntityType.PIGLIN_BRUTE)
        	.add(EntityType.STRIDER)
           	.add(EntityType.WITHER_SKELETON)
           	.add(EntityType.HOGLIN)
           	.add(EntityType.ZOGLIN)
           	.add(EntityType.ZOMBIFIED_PIGLIN)
            .add(EntityType.GHAST);
        
	    tag(ModEntityTypeTags.VILLAGE_INHABITANTS)
			.add(EntityType.VILLAGER)
			.add(EntityType.IRON_GOLEM);
			
    }

    @Override
    public String getName()
    {
        return "Unique Magic EntityType Tags";
    }
}