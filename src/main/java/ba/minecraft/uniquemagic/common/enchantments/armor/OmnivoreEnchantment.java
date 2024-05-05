package ba.minecraft.uniquemagic.common.enchantments.armor;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.Tags;

public class OmnivoreEnchantment extends ModEnchantment {

    public OmnivoreEnchantment() {
        super(ItemTags.HEAD_ARMOR_ENCHANTABLE, 2, 1, Enchantment.constantCost(20), Enchantment.constantCost(50), 4, new EquipmentSlot[]{ EquipmentSlot.HEAD });
    }
    
    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.is(Tags.Items.ARMORS_HELMETS);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return this.canEnchant(stack);
    }

	@Override
	protected String getBaseName() {
		return "Omnivore";
	}
}
