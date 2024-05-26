package ba.minecraft.uniquemagic.common.enchantments.armor;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class FreezingProtectionEnchantment extends ModEnchantment {

	public FreezingProtectionEnchantment() {
		super(ItemTags.ARMOR_ENCHANTABLE, 5, 4, Enchantment.dynamicCost(10, 8), Enchantment.dynamicCost(18, 8), 2, new EquipmentSlot[]{ EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET } );
	}

	@Override
	protected String getBaseName() {
		return "Freezing Protection";
	}

	@Override
	public int getDamageProtection(int enchantmentLevel, DamageSource damageSource) {
        
		// IF: Damage bypassed protection enchantments.
		if (damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return 0;
        }
        
		// IF: Damage is coming from lightining.
		if (damageSource.is(DamageTypeTags.IS_FREEZING)) {
			return enchantmentLevel * UniqueMagicModConfig.FREEZING_PROTECTION_BASE_MULTIPLIER;
		}
		
		return 0;
	}

	@Override
	protected boolean checkCompatibility(Enchantment otherEnchantment) {

		// IF: Protection enchantment is already applied.
		if (otherEnchantment instanceof ProtectionEnchantment protectionEnchantment) {

			// IF: Protection enchantment is fall.
			if(protectionEnchantment.type == ProtectionEnchantment.Type.FALL) {
				
				// It is possible to enchant.
				return true;
			} else {
				// Otherwise it should not be possible to combine.
				return false;
			}
        }
        
        return super.checkCompatibility(otherEnchantment);
	}
	

}