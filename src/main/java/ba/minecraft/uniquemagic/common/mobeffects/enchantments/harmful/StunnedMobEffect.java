package ba.minecraft.uniquemagic.common.mobeffects.enchantments.harmful;

import ba.minecraft.uniquemagic.common.capabilities.enchantments.ModEnchantmentCapabilities;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public final class StunnedMobEffect extends MobEffect {
	
	public StunnedMobEffect() {
		super(MobEffectCategory.HARMFUL, 0x555555);
	}
	
	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		return true;
	}

	// Overridden to implement logic on what happens when mob has this buff.
	@Override
	public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {

		// IF: Code is executing on client side - do nothing.
		if(livingEntity.level().isClientSide()) {
			return false;
		}
		
		livingEntity.getCapability(ModEnchantmentCapabilities.STUNNED_CAPABILITY).ifPresent(stunCapability -> {

			// Get current stunned position.
			Vec3 stunnedPos = stunCapability.getStunnedPosition();

			// Get vector to current position of entity.
            Vec3 currentPos = livingEntity.position();

			// IF: Mob was not previously stunned.
			if (stunnedPos.x() == 0 && stunnedPos.y() == 0 && stunnedPos.z() == 0) {
				
				// Save current coordinates as stun coordintates.
				stunCapability.setStunnedPosition(currentPos);
				
				// Assign saved coordinates to stun position
                stunnedPos = stunCapability.getStunnedPosition();
            }


             // IF: There is a difference in positions (entity has attempted to move).
            if (!currentPos.equals(stunnedPos)) {
            	
            	// Teleport it back.
            	livingEntity.teleportTo(stunnedPos.x(), stunnedPos.y(), stunnedPos.z());
            }
             
     		// Reduce movement speed to 0.
     		livingEntity.setDeltaMovement(0, 0, 0);

         });
		
		return true;
	}

}
