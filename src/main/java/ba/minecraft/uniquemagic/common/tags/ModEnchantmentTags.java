package ba.minecraft.uniquemagic.common.tags;

import ba.minecraft.uniquemagic.common.helpers.ModResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ModEnchantmentTags {

	public static void init() {}

    public static final TagKey<Enchantment> UNIQUE_MAGIC = create("unique_magic");
    public static final TagKey<Enchantment> XP_GAIN_EXCLUSIVE = create("xp_gain_exclusive");
    public static final TagKey<Enchantment> MOB_EFFECT_EXCLUSIVE = create("mob_effect_exclusive");

    private static TagKey<Enchantment> create(String name)
    {
        return TagKey.create(Registries.ENCHANTMENT, ModResourceLocation.create(name));
    }
}
