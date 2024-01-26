package ba.minecraft.uniquemagic.common.mobeffects.harmful;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public final class StunnedMobEffect extends MobEffect {

	public StunnedMobEffect() {
		super(MobEffectCategory.HARMFUL, 0x555555);
	}
	
	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return true;
	}

	// Overridden to implement logic on what happens when mob has this buff.
	@Override
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {

		// IF: Code is executing on client side - do nothing.
		if(livingEntity.level().isClientSide()) {
			return;
		}

		// Reduce movement speed to 0.
		livingEntity.setDeltaMovement(0, 0, 0);

		double posX = livingEntity.getX();
		double posY = livingEntity.getY();
		double posZ = livingEntity.getZ();

		// Teleport entity back to starting position.
		livingEntity.teleportTo(posX, posY, posZ);
		
	}

}
