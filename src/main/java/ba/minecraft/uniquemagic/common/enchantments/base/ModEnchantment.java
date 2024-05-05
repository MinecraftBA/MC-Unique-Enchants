package ba.minecraft.uniquemagic.common.enchantments.base;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public abstract class ModEnchantment extends Enchantment  {

	protected ModEnchantment(TagKey<Item> itemTags, int weight, int maxLevel, Cost minCost, Cost maxCost, int anvilCost, EquipmentSlot[] applicableSlots) {
		super(Enchantment.definition(itemTags, weight, maxLevel, minCost, maxCost, anvilCost, applicableSlots));
	}

	/**
	 * Override to define base name of enchantment, without level.
	 * @return Base name of enchantment.
	 */
	protected abstract String getBaseName();
	
	@Override
	public Component getFullname(int enchantmentLevel) {
	      MutableComponent mutablecomponent = Component.literal(this.getBaseName());
	      if (this.isCurse()) {
	         mutablecomponent.withStyle(ChatFormatting.RED);
	      } else {
	         mutablecomponent.withStyle(ChatFormatting.GRAY);
	      }

	      if (enchantmentLevel != 1 || this.getMaxLevel() != 1) {
	         mutablecomponent.append(CommonComponents.SPACE).append(Component.translatable("enchantment.level." + enchantmentLevel));
	      }

	      return mutablecomponent;
	}
}
