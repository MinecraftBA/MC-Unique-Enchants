package ba.minecraft.uniquemagic.common.tags;

import ba.minecraft.uniquemagic.common.helpers.ModResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ModEnchantmentTags {

	public static void init() {}

    public static final TagKey<Enchantment> PROTECTION = create("protection");

    private static TagKey<Enchantment> create(String name)
    {
        return TagKey.create(Registries.ENCHANTMENT, ModResourceLocation.create(name));
    }
}
