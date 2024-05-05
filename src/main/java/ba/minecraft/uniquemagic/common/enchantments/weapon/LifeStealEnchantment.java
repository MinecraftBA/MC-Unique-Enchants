package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class LifeStealEnchantment extends ModEnchantment {

	public LifeStealEnchantment() {
		super(ItemTags.WEAPON_ENCHANTABLE, 2, 5, Enchantment.constantCost(25), Enchantment.dynamicCost(5, 8), 4, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	protected String getBaseName() {
		return "Life steal";
	}
	
}
