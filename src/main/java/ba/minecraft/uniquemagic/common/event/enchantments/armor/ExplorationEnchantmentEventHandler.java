package ba.minecraft.uniquemagic.common.event.enchantments.armor;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class ExplorationEnchantmentEventHandler {
	
	@SubscribeEvent
	public static void onPlayerXpChange(final PlayerXpEvent.XpChange event) {

		// Get reference to player that has picked up orb.
        Player player = event.getEntity();
        
        // Get reference to level where code is executing.
        Level level = player.level();
        
        // IF: Code is executing on client side.
        if(level.isClientSide) {
        	
        	// Do nothing.
        	return;
        }

        // Get reference to helmet that player is carrying.
    	ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        
    	// IF: Player is not carrying helmet.
    	if(helmet == null) {
    		
    		// Do nothing.
    		return;
    	}
    	
    	// Get enchantment level on helmet.
    	int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(ArmorEnchantments.EXPLORATION.get(), helmet);
        
    	// IF: There is
    	if (enchantmentLevel > 0) {
    		
    		// Calculate increment ratio based on the confiugration and enchantment level.
    		double incrementRatio = UniqueMagicModConfig.EXPLORATION_BASE_PERCENTAGE_INCREMENT * enchantmentLevel / (double)100;
    		
    		// Calculate the amount of XP after increment.
    		int xpAmount = (int)(event.getAmount() * (1 + incrementRatio));
    		
    		// Set XP amount to be given to player.
            event.setAmount(xpAmount);
        }
    }
	
}
