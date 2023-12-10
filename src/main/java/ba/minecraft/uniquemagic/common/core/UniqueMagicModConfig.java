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

    public static int EXECUTE_BASE_CHANCE;
    public static int LIFE_STEAL_BASE_RATIO;
    
    static {
    	BUILDER.push("Configs for Unique Magic Mod");

    	EXECUTE_BASE_CHANCE_CONFIG = BUILDER.comment("Base chance for Execute enchantntment to trigger.")
	            .defineInRange("Execute Base Chance", 1, 1, 20);

    	LIFE_STEAL_BASE_RATIO_CONFIG = BUILDER.comment("Base damage-to-heal conversion ratio for life steal enchantment.")
    	            .defineInRange("Life Steal Base Ratio", 5, 1, 20);
    	
    	BUILDER.pop();
    	
    	SPEC = BUILDER.build();
    }
    
    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event)
    {
    	EXECUTE_BASE_CHANCE = EXECUTE_BASE_CHANCE_CONFIG.get();
    	LIFE_STEAL_BASE_RATIO = LIFE_STEAL_BASE_RATIO_CONFIG.get();
    }
}
