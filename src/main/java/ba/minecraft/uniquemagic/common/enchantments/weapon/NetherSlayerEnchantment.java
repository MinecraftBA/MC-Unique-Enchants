package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import ba.minecraft.uniquemagic.common.tags.ModEntityTypeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NetherSlayerEnchantment  extends ModEnchantment {

	public NetherSlayerEnchantment() {
		super(ItemTags.WEAPON_ENCHANTABLE, 5, 5, Enchantment.dynamicCost(5, 8), Enchantment.dynamicCost(25, 8), 2, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	protected String getBaseName() {
		return "Nether Slayer";
	}

	@Override
	public float getDamageBonus(int enchantmentLevel, EntityType<?> mobType, ItemStack enchantedItem) {
		if (mobType != null && mobType.is(ModEntityTypeTags.NETHER_MOBS)) {
			return enchantmentLevel * UniqueMagicModConfig.NETHER_SLAYER_BASE_MULTIPLIER;
		} else {
			return 0;
		}
	}

}

   

	 
	

