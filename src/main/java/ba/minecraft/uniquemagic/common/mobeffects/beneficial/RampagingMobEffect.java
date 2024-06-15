package ba.minecraft.uniquemagic.common.mobeffects.beneficial;

import ba.minecraft.uniquemagic.common.helpers.ModResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;

public final class RampagingMobEffect extends MobEffect {
	
	 public RampagingMobEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFF0000);
        
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ModResourceLocation.create("effect.rampaging"), 0.5, Operation.ADD_MULTIPLIED_TOTAL);
    }

	 
}
