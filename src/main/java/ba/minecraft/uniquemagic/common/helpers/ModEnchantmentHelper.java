package ba.minecraft.uniquemagic.common.helpers;

import net.minecraft.core.Holder.Reference;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ModEnchantmentHelper {

	public static boolean is(Enchantment enchantment, TagKey<Enchantment> tag) {

		Reference<Enchantment> holder = enchantment.builtInRegistryHolder();
		
		// Check if enchantment is tagged.
		return holder.is(tag);
	}
}
