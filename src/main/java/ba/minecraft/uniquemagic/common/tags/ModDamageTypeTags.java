package ba.minecraft.uniquemagic.common.tags;

import ba.minecraft.uniquemagic.common.helpers.ModResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;

public final class ModDamageTypeTags {

	public static void init() {}

    public static final TagKey<DamageType> MAGIC = create("magic");

    private static TagKey<DamageType> create(String name)
    {
        return TagKey.create(Registries.DAMAGE_TYPE, new ModResourceLocation(name));
    }
}
