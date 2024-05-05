package ba.minecraft.uniquemagic.common.enchantments.tool;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class TimberEnchantment extends ModEnchantment {

	public TimberEnchantment() {
		super(ItemTags.AXES, 2, 1, Enchantment.constantCost(20), Enchantment.constantCost(50), 4, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}
	
	protected String getBaseName() {
		return "Timber";
	}
}