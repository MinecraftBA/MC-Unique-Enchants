package ba.minecraft.uniquemagic.common.helpers;

import net.minecraft.core.Holder.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ModEnchantmentHelper {

	public static boolean is(Enchantment enchantment, TagKey<Enchantment> tag) {

		// Get reference to enchantment holder.
		Reference<Enchantment> holder = BuiltInRegistries.ENCHANTMENT.createIntrusiveHolder(enchantment);
		
		// Check if enchantment is tagged.
		return holder.is(tag);
	}
}
