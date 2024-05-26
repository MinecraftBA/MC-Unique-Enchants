package ba.minecraft.uniquemagic.common.enchantments.armor;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.MendingEnchantment;
import net.minecraftforge.common.Tags;

public class ExplorationEnchantment extends ModEnchantment {

    public ExplorationEnchantment() {
        super(ItemTags.HEAD_ARMOR_ENCHANTABLE, 1, 5, Enchantment.dynamicCost(1, 8), Enchantment.dynamicCost(21, 8), 8, new EquipmentSlot[]{ EquipmentSlot.HEAD });
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
		return "Exploration";
	}

	@Override
	protected boolean checkCompatibility(Enchantment otherEnchantment) {

		// IF: Other enchantment is Mending.
		if (otherEnchantment instanceof MendingEnchantment) {
			
			// Cannot work together.
			return false;
		}
		
		return super.checkCompatibility(otherEnchantment);
	}
	
}