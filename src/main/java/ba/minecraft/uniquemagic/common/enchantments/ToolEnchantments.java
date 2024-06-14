package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ToolEnchantments {
	
    public static final ResourceKey<Enchantment> TIMBER = ModEnchantmentHelper.createResourceKey("timber");
	
    public static void bootstrap(BootstrapContext<Enchantment> context) {
    }
}
