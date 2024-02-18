package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.common.Tags;

public class IllagersBaneEnchantment extends ModEnchantment {
	
	public IllagersBaneEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD});
    }
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
	
    @Override
    public int getMinCost(int enchantmentLevel) {
        return 35;
    }

    @Override
    public int getMaxCost(int enchantmentLevel) {
        return this.getMinCost(enchantmentLevel) + 20;
    }
    
    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.is(Tags.Items.TOOLS);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return this.canEnchant(stack);
    }

	@Override
	protected String getBaseName() {
		return "Illager's Bane";
	}
}
