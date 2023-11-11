package ba.minecraft.uniquemagic.common.enchantments.tool;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class TimberEnchantment extends ModEnchantment {

	public TimberEnchantment() {
		super(Rarity.COMMON, EnchantmentCategory.DIGGER, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	public int getMinLevel() {
		return 1;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean canEnchant(ItemStack pStack) {
		
		// Get type of item to be enchanted.
		Item item = pStack.getItem();
		
		// IF: Item is not an axe - it does not extend AxeItem.
		if(!(item instanceof AxeItem)) {
			
			// Don't allow enchanting.
			return false;
		}
		
		// Otherwise do standard enchanting check.
		return super.canEnchant(pStack);
	}
	
	protected String getBaseName() {
		return "Timber";
	}
}