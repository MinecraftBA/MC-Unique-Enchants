package ba.minecraft.uniqueenchants.common.enchantments.weapon;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LifeStealEnchantment extends Enchantment {

	public LifeStealEnchantment() {
		super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public int getMinCost(int enchantmentLevel) {
		return 10 + 20 * (enchantmentLevel - 1);
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return getMinCost(enchantmentLevel) + 50;
	}
	
}
