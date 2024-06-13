package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
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
		int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(WeaponEnchantments.DISARM.getHolder().get(), attackerItem);
		
		// IF: Enchantment was not found on weapon.
		if (enchantmentLevel < 1) {
			// Do nothing.
			return;
		}
		
		// Create random generator.
		RandomSource random = level.getRandom();
		
		// Calculate proc chance - % for every level of enchantment.
		int hitChance = enchantmentLevel * UniqueMagicModConfig.DISARM_BASE_CHANCE;
		
		// Get number between 0 and 99.
		int roll = random.nextInt(100);
		
		// IF: Apply on hit chance was missed.
		if (roll >= hitChance) {
			
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
