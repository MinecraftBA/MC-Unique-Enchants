package ba.minecraft.uniquemagic.common.mobeffects.enchantments.harmful;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public final class StunnedMobEffect extends MobEffect {

	private double posX;
	private double posY;
	private double posZ;
	
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
		
		// Teleport entity back to starting position.
		livingEntity.teleportTo(posX, posY, posZ);
		
		// Reduce movement speed to 0.
		livingEntity.setDeltaMovement(0, 0, 0);
		
		return true;
	}

	@Override
	public void onEffectStarted(LivingEntity livingEntity, int amplifier) {
		// Capture coordinates of where mob was when effect started.
		posX = livingEntity.getX();
		posY = livingEntity.getY();
		posZ = livingEntity.getZ();
	}

}
