package ba.minecraft.uniquemagic.common.enchantments.armor;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.Tags;

public class OmnivoreEnchantment extends ModEnchantment {

    public OmnivoreEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD});
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
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.is(Tags.Items.ARMORS_HELMETS); // Change to your helmet item
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return this.canEnchant(stack);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if (target instanceof Player) {
            Player player = (Player) target;
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

            if (EnchantmentHelper.getItemEnchantmentLevel(this, helmet) > 0) {
                FoodProperties food = player.getUseItem().getItem().getFoodProperties();
                
                if (food != null && food.isMeat()) {
                    // Assuming that the enchantment level determines the strength of the effect
                    player.removeEffect(MobEffects.POISON);
                    player.removeEffect(MobEffects.WITHER);
                    player.removeEffect(MobEffects.CONFUSION);
                    player.removeEffect(MobEffects.HUNGER);
                    // Add more effects to clear as needed
                }
            }
        }
    }

	@Override
	protected String getBaseName() {
		return "Omnivore";
	}
}
