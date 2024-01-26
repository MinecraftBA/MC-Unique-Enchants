package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.mobeffects.HarmfulMobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class StunEnchantmentEventHandler {

	@SubscribeEvent
	public static void onLivingAttack(final LivingAttackEvent event) {
		
		// Get source of the damage.
		DamageSource damageSource = event.getSource();
		
		// Get reference to entity that caused the damage.
		Entity attacker = damageSource.getEntity();

		// IF: Attack was not done by entity.
		if (attacker == null) {
			
			// Do nothing.
			return;
		}

		// Get reference to level where event has occurred.
		Level level = attacker.level();
		
		// IF: Code is executing on the client side.
		if (level.isClientSide()) {

			// Do nothing.
			return;
		}
		
		// IF: Attacker was not living entity.
		if(!(attacker instanceof LivingEntity)) {

			// Do nothing.
			return;
		}
		
		// Cast entity to player.
		LivingEntity attackerMob = (LivingEntity)attacker;

		// Get instance of stun effect.
		MobEffectInstance stunInstance = attackerMob.getEffect(HarmfulMobEffects.STUNNED.get());
		
		// IF: Effect was not applied.
		if(stunInstance == null) {
			
			// Do nothing.
			return;
		}

		// Cancel the attack.
		event.setCanceled(true);
	}
}
