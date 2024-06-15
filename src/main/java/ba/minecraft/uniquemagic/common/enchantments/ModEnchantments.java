package ba.minecraft.uniquemagic.common.enchantments;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ModEnchantments {

	public static void bootstrap(BootstrapContext<Enchantment> context) {

		ArmorEnchantments.bootstrap(context);
		BowEnchantments.bootstrap(context);
		ToolEnchantments.bootstrap(context);
		WeaponEnchantments.bootstrap(context);
		
    }
}
