package ba.minecraft.uniquemagic.common.event.enchantments.armor;

import java.util.List;

import com.mojang.datafixers.util.Pair;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchants;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent.Finish;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class OmnivoreEnchantmentEventHandler {

	@SubscribeEvent
	public static void onFinishUseItem(final Finish event) {
		
		// Get reference to entity that has used the item.
		LivingEntity livingEntity = event.getEntity();
		
		// Get reference to a level where code is executing.
		Level level = livingEntity.level();
		
		// IF: Code is executing on client side.
		if(level.isClientSide()) {
			
			// Do nothing.
			return;
		}
		
		// IF: Entity is not player.
		if(!(livingEntity instanceof Player)) {
			// Do nothing.
			return;
		}
		
		// Cast living entity to player.
		Player player = (Player)livingEntity;
		
		// Get item on head.
		ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
		
		// IF: There is nothing on head.
		if(helmet == null) {
			
			// Do nothing.
			return;
		}
		
		// IF: Enchant is not applied on head item.
		if (helmet.getEnchantmentLevel(ArmorEnchants.OMNIVORE.get()) < 1) {

			// Do nothing.
			return;
		}
		
		// Get reference to item that was used.
		ItemStack itemStack = event.getItem();
		
		// Get reference to item type.
		Item item = itemStack.getItem();
		
		// IF: Item is not food.
		if(!item.isEdible()) {
			
			// Do nothing.
			return;
		}
		
		// Get reference to food properties of item.
		FoodProperties foodProperties = item.getFoodProperties(itemStack, livingEntity);
		
		// Get list of effects that are applied when food is eaten.
		List<Pair<MobEffectInstance, Float>> effectPairs = foodProperties.getEffects();
		
		// Iterate through all effect pairs.
		for(Pair<MobEffectInstance, Float> effectPair : effectPairs ) {
			
			// Get mob effect instance from pair.
			MobEffectInstance mobEffectInstance = effectPair.getFirst();
			
			// Get reference to mob effect.
			MobEffect mobEffect = mobEffectInstance.getEffect();
			if(!(mobEffect.isBeneficial() == true)) {
				// Remove mob effect from player.
				player.removeEffect(mobEffect);
			} 
		}
	}
}
