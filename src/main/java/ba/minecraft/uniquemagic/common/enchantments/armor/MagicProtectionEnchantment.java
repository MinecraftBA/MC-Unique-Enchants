package ba.minecraft.uniquemagic.common.enchantments.armor;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import ba.minecraft.uniquemagic.common.tags.ModDamageTypeTags;
import ba.minecraft.uniquemagic.common.tags.ModEnchantmentTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class MagicProtectionEnchantment extends ModEnchantment{
	
	public MagicProtectionEnchantment() {
		super(ItemTags.ARMOR_ENCHANTABLE, 5, 4, Enchantment.dynamicCost(10, 8), Enchantment.dynamicCost(18, 8), 2, new EquipmentSlot[]{ EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET } );
	}

	@Override
	protected String getBaseName() {
		return "Magic Protection";
	}

	@Override
	public int getDamageProtection(int enchantmentLevel, DamageSource damageSource) {
        
		// IF: Damage bypassed protection enchantments.
		if (damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return 0;
        }
        
		// IF: Damage is coming from magic.
		if (damageSource.is(ModDamageTypeTags.MAGIC)) {
			return enchantmentLevel * UniqueMagicModConfig.MAGIC_PROTECTION_BASE_MULTIPLIER;
		}
		
		return 0;
	}

	@Override
	protected boolean checkCompatibility(Enchantment otherEnchantment) {

		// IF: Other enchantment is also attack damage protection.
		if(ModEnchantmentHelper.is(otherEnchantment, ModEnchantmentTags.PROTECTION)) {
			
			// Do nothing.
			return false;
		}
        
        return super.checkCompatibility(otherEnchantment);
	}
}
