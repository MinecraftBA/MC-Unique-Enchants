package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public final class IllagersBaneEnchantment extends ModEnchantment {
	
	public IllagersBaneEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{ EquipmentSlot.MAINHAND });
    }
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
	
	@Override
	public int getMinCost(int enchantmentLevel) {
		return 25;
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return getMinCost(enchantmentLevel) + 50;
	}
    
	@Override
	protected String getBaseName() {
		return "Illager's Bane";
	}

	@Override
	public float getDamageBonus(int enchantmentLevel, MobType mobType) {
		if(mobType == MobType.ILLAGER) {
			return enchantmentLevel * UniqueMagicModConfig.ILLAGERS_BANE_BASE_MULTIPLIER;
		} else {
			return 0;
		}
	}
	
}
