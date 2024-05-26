package ba.minecraft.uniquemagic.common.event.enchantments.armor;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchants;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public class ExplorationEnchantmentEventHandler {
	
	@SubscribeEvent
	public void onPlayerGainXP(PlayerXpEvent.XpChange event) {
        Player player = event.getEntity();
        if (player != null) {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            int level = EnchantmentHelper.getItemEnchantmentLevel(ArmorEnchants.EXPLORATION.get(), helmet);
            if (level > 0) {
                event.setAmount(event.getAmount() * (1 + level));
            }
        }
    }

	
}
