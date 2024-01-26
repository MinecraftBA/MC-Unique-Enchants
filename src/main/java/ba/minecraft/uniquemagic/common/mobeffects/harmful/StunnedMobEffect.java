package ba.minecraft.uniquemagic.common.mobeffects.harmful;

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
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {

		// IF: Code is executing on client side - do nothing.
		if(livingEntity.level().isClientSide()) {
			return;
		}
		
		double diffX = posX - livingEntity.getX();
		double diffY = posY - livingEntity.getY();
		double diffZ = posZ - livingEntity.getZ();
		
		//livingEntity.teleportTo(posX, posY, posZ);
		livingEntity.setDeltaMovement(diffX, diffY, diffZ);
		
		System.out.println("ticking");
	}

	
	@Override
	public void onEffectStarted(LivingEntity livingEntity, int amplifier) {
		
		System.out.println("started");
		
		// Capture coordinates of where mob was when effect started.
		posX = livingEntity.getX();
		posY = livingEntity.getY();
		posZ = livingEntity.getZ();
	}

}
