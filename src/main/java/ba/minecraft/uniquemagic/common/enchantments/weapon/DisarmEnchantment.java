package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public final class DisarmEnchantment extends ModEnchantment {

    public DisarmEnchantment() {
        super(ItemTags.WEAPON_ENCHANTABLE, 1, 5, Enchantment.constantCost(25), Enchantment.constantCost(50), 8, new EquipmentSlot[]{ EquipmentSlot.MAINHAND });
    }

	@Override
	protected String getBaseName() {
		return "Disarm";
	}
}
