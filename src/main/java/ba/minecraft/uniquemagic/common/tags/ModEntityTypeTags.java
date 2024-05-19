package ba.minecraft.uniquemagic.common.tags;

import ba.minecraft.uniquemagic.common.helpers.ModResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeTags {

    public static void init() {}

    public static final TagKey<EntityType<?>> NETHER_MOBS = create("nether_mobs");

    private static TagKey<EntityType<?>> create(String name)
    {
        return TagKey.create(Registries.ENTITY_TYPE, new ModResourceLocation(name));
    }
}
