package ba.minecraft.uniquemagic.common.enchantments.bow;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class TriggerEnchantment extends ModEnchantment {

	public TriggerEnchantment() {
		super(ItemTags.BOW_ENCHANTABLE, 1, 1, Enchantment.constantCost(20), Enchantment.constantCost(50), 8, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	protected String getBaseName() {
		return "Trigger";
	}

}
