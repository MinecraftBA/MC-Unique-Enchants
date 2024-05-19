package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NetherSlayerEnchantmentEventHandler {
	
	@SubscribeEvent
    public static void onEntityHit(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof Player) {
            Player player = (Player) event.getSource().getTrueSource();
            ItemStack weapon = player.getHeldItemMainhand();
            if (weapon.isEnchanted() && event.getEntityLiving().world.getDimensionKey() == World.THE_NETHER) {
                int level = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(EnchantmentsInit.NETHER_SLAYER, weapon);
                if (level > 0) {
                    float extraDamage = 2.5f * level; // Adjust damage multiplier as needed
                    event.setAmount(event.getAmount() + extraDamage);
                }
            }
        }
    }
}
