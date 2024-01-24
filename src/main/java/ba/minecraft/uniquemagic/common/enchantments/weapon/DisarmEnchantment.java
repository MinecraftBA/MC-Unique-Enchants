package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment.Rarity;

public class DisarmEnchantment extends ModEnchantment {

    public DisarmEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return 10;
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    
    
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user instanceof Player) {
            Player player = (Player) target;
            if (user.getRandom().nextFloat() < 0.2f) { // Adjust chance as needed
                ItemStack itemInMainHand = player.getMainHandItem();
                if (!itemInMainHand.isEmpty()) {
                    player.drop(itemInMainHand, isAllowedOnBooks());
                }
            }
        }
    }

	@Override
	protected String getBaseName() {
		
		return "Disarm";
	}
}
