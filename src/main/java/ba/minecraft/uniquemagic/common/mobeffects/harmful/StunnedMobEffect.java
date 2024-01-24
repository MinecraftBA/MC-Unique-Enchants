package ba.minecraft.uniquemagic.common.mobeffects.harmful;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public final class StunnedMobEffect extends MobEffect {

	public StunnedMobEffect() {
		super(MobEffectCategory.HARMFUL, 0x555555);
	}

	// Overridden to enable logic in applyEffectTick to be executed on every effect tick.
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	// Overridden to implement logic on what happens when player has this buff.
	@Override
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {

		// IF: Code is executing on client side - do nothing.
		if(livingEntity.level().isClientSide()) {
			return;
		}
		
		double posX = livingEntity.getX();
		double posY = livingEntity.getY();
		double posZ = livingEntity.getZ();
		
		livingEntity.teleportTo(posX, posY, posZ);
		livingEntity.setDeltaMovement(0, 0, 0);
	}

}
