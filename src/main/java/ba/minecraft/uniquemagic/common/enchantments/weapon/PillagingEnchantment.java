package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import ba.minecraft.uniquemagic.common.tags.ModEntityTypeTags;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public final class PillagingEnchantment extends ModEnchantment {

	public PillagingEnchantment() {
		super(ItemTags.WEAPON_ENCHANTABLE, 5, 5, Enchantment.dynamicCost(5, 8), Enchantment.dynamicCost(25, 8), 2, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	protected String getBaseName() {
		return "Illager's Bane";
	}

	@Override
	public float getDamageBonus(int enchantmentLevel, EntityType<?> mobType , ItemStack enchantedItem) {
		if (mobType != null && mobType.is(ModEntityTypeTags.VILLAGE_INHABITANTS)) {
			return enchantmentLevel * UniqueMagicModConfig.PILLAGING_BASE_MULTIPLIER;
		} else {
			return 0;
		}
	}

}