package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public final class BowEnchantments {

    public static final ResourceKey<Enchantment> TRIGGER = ModEnchantmentHelper.createResourceKey("trigger");
	
    public static void bootstrap(BootstrapContext<Enchantment> context) {
    }
}

