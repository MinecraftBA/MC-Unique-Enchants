package ba.minecraft.uniquemagic.common.mobeffects.beneficial;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class RampagingMobEffect extends MobEffect{
	
	 public RampagingMobEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFFFFF); // Change the color to what you prefer
    }

	@Override
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
		
		// IF: Code is executing on client side.
		if(livingEntity.level().isClientSide()) {
			
			// Do nothing.
			return;
		}
		
		// IF: Entity is not player.
		if(!(livingEntity instanceof Player)) {
			
			// Do nothing.
			return;
		}
		
		// Cast living entity to server player.
		ServerPlayer player = (ServerPlayer)livingEntity;
		
		// Get reference to attack speed attribute.
		AttributeInstance attribute = player.getAttribute(Attributes.ATTACK_SPEED);
		
		attribute.setBaseValue(4 * (1.5 + amplifier * 0.5)); // 50% increase plus 50% per amplifier level } }
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
		// Ensures that effect is applied for every tick.
		return true;
	}
	 
}
