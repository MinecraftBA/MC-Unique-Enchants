package ba.minecraft.uniquemagic.common.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class UniqueMagicModConfig {

	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    private static final ForgeConfigSpec.IntValue EXECUTE_BASE_CHANCE_CONFIG;
    private static final ForgeConfigSpec.IntValue LIFE_STEAL_BASE_RATIO_CONFIG;

    private static final ForgeConfigSpec.IntValue WITHERING_BASE_CHANCE_CONFIG;
    private static final ForgeConfigSpec.IntValue WITHERING_BASE_DURATION_CONFIG;
    
    private static final ForgeConfigSpec.IntValue POISON_BASE_CHANCE_CONFIG;
    private static final ForgeConfigSpec.IntValue POISON_BASE_DURATION_CONFIG;
    
    public static int EXECUTE_BASE_CHANCE;
    public static int LIFE_STEAL_BASE_RATIO;
    
    public static int WITHERING_BASE_CHANCE;
    public static int WITHERING_BASE_DURATION;
    
    public static int POISON_BASE_CHANCE;
    public static int POISON_BASE_DURATION;
    
    static {
    	BUILDER.push("Configs for Unique Magic Mod");

    	EXECUTE_BASE_CHANCE_CONFIG = BUILDER.comment("Base chance for Execute enchantment to trigger.")
	            .defineInRange("Execute base chance", 1, 1, 20);

    	LIFE_STEAL_BASE_RATIO_CONFIG = BUILDER.comment("Base damage-to-heal conversion ratio for Life Steal enchantment.")
    	        .defineInRange("Life Steal base ratio", 5, 1, 20);

    	WITHERING_BASE_CHANCE_CONFIG = BUILDER.comment("Base chance for Withering enchantment to trigger.")
    	        .defineInRange("Withering base chance", 5, 1, 20);

    	WITHERING_BASE_DURATION_CONFIG = BUILDER.comment("Base duration for Withering enchantment in seconds.")
    	        .defineInRange("Withering base duration", 3, 1, 60);
    	
    	POISON_BASE_CHANCE_CONFIG = BUILDER.comment("Base chance for Poison enchantment to trigger.")
    	        .defineInRange("Poison base chance", 5, 1, 20);

    	POISON_BASE_DURATION_CONFIG = BUILDER.comment("Base duration for Poison enchantment in seconds.")
    	        .defineInRange("Poison base duration", 3, 1, 60);

    	BUILDER.pop();
    	
    	SPEC = BUILDER.build();
    }
    
    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event)
    {
    	EXECUTE_BASE_CHANCE = EXECUTE_BASE_CHANCE_CONFIG.get();
    	LIFE_STEAL_BASE_RATIO = LIFE_STEAL_BASE_RATIO_CONFIG.get();
    	
    	WITHERING_BASE_CHANCE = WITHERING_BASE_CHANCE_CONFIG.get();
    	WITHERING_BASE_DURATION = WITHERING_BASE_DURATION_CONFIG.get();
    	
    	POISON_BASE_CHANCE = POISON_BASE_CHANCE_CONFIG.get();
    	POISON_BASE_DURATION = POISON_BASE_DURATION_CONFIG.get();
	}
}
