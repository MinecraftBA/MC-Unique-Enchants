package ba.minecraft.uniquemagic.common.mobeffects.beneficial;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;

public final class RampagingMobEffect extends MobEffect {
	
	 public RampagingMobEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFF0000); // Change the color to what you prefer
        
		this.addAttributeModifier(Attributes.ATTACK_SPEED, "1B4A6E69-1E81-4854-A36A-8CADE80AAD45", 0.5, Operation.ADD_MULTIPLIED_TOTAL);
    }

	 
}
