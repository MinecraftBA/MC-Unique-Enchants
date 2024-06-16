package ba.minecraft.uniquemagic.common.tags;

import ba.minecraft.uniquemagic.common.helpers.ModResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public final class ModEntityTypeTags {

    public static void init() {}

    public static final TagKey<EntityType<?>> NETHER_MOBS = create("nether_mobs");
    public static final TagKey<EntityType<?>> VILLAGE_INHABITANTS = create("village_inhabitants");

    private static TagKey<EntityType<?>> create(String name)
    {
        return TagKey.create(Registries.ENTITY_TYPE, ModResourceLocation.create(name));
    }
}
