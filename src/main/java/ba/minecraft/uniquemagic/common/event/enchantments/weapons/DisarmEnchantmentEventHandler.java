package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchants;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class DisarmEnchantmentEventHandler {

	@SubscribeEvent
	public static void onAttackEntity(final AttackEntityEvent event) {

		// Get reference to entity that was attacked.
		Entity entity = event.getTarget();
		
		// IF: Entity is not a player.
		if(!(entity instanceof Player)) {
			// Do nothing.
			return;
		}
		
		// Cast entity to player.
		Player target = (Player)entity;

		// Get reference to a player that did the damage.
		Player attacker = event.getEntity();

		// Get reference to a level where attack was done.
		Level level = attacker.level();
		
		// IF: Code is executing on client side.
		if(level.isClientSide())
		{
			// Do nothing.
			return;
		}
		
		// Get attacker item in main hand.
		ItemStack attackerItem = attacker.getItemInHand(InteractionHand.MAIN_HAND);
		
		// IF: There is no weapon in main hand of attacker.
		if(attackerItem == null) {
			// Do nothing.
			return;
		}
		
		// Get level of disarm enchantment.
		int enchantmentLevel = attackerItem.getEnchantmentLevel(WeaponEnchants.DISARM.get());
		
		// IF: Enchantment was not found on weapon.
		if (enchantmentLevel < 1) {
			// Do nothing.
			return;
		}

		// Get item that target is holding in hand.
		ItemStack targetItem = target.getItemInHand(InteractionHand.MAIN_HAND);
		
		// IF: Target does not have item equipped in main hand.
		if(targetItem == null) {
			// Do nothing.
			return;
		}

		// Have target player drop item.
		target.drop(targetItem, true, true);
		
		// Get reference to inventory of target player.
		Inventory targetInventory = target.getInventory();
		
		// Remove item from target player's inventory.
		targetInventory.removeItem(targetItem);
	}
}
