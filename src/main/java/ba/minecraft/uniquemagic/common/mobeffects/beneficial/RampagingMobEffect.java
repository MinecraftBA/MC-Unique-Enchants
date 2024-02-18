package ba.minecraft.uniquemagic.common.mobeffects.beneficial;



import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class RampagingMobEffect extends MobEffect{
	
	 public RampagingMobEffect() {
	        super(MobEffectCategory.BENEFICIAL, 0xFFFFFF); // Change the color to what you prefer
	    }


	    public void applyEffectTick(LivingEntity entity, int amplifier) {
	        if (entity instanceof Player) {
	            Player player = (Player) entity;
	            // Assuming 4 is the base attack speed for a player. This will need to be adjusted based on actual gameplay mechanics.
	            player.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(4 * (1.5 + amplifier * 0.5)); // 50% increase plus 50% per amplifier level
	        }
	    }

	    public boolean isDurationEffectTick(int duration, int amplifier) {
	        return true; // This makes sure the effect is applied every tick
	    }
}
