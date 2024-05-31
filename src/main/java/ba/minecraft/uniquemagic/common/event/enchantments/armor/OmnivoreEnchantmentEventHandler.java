package ba.minecraft.uniquemagic.common.event.enchantments.armor;

import java.util.List;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchantments;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.PossibleEffect;
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
		if (helmet.getEnchantmentLevel(ArmorEnchantments.OMNIVORE.get()) < 1) {

			// Do nothing.
			return;
		}
		
		// Get reference to item that was used.
		ItemStack itemStack = event.getItem();
		
		// Get food properties of item stack.
		FoodProperties foodProperties = itemStack.get(DataComponents.FOOD);
		
		// IF: Item is not food.
		if(foodProperties == null) {
			
			// Do nothing.
			return;
		}
		
		// Get list of effects that are applied when food is eaten.
		List<PossibleEffect> possibleEffects = foodProperties.effects();
		
		// Iterate through all effect pairs.
		for(PossibleEffect possibleEffect : possibleEffects ) {

			// Get reference to mob effect instance.
			MobEffectInstance mobEffectInstance = possibleEffect.effect();
			
			// Get reference to mob effect.
			Holder<MobEffect> mobEffect = mobEffectInstance.getEffect();
			if(!(mobEffect.get().isBeneficial() == true)) {
				// Remove mob effect from player.
				player.removeEffect(mobEffect);
			} 
		}
	}
}
