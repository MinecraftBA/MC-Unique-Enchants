package ba.minecraft.uniquemagic.common.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class UniqueMagicModConfig {

	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue BLIND_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Blind enchantment to trigger.")
        .defineInRange("Blind base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue BLIND_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Blind enchantment in seconds.")
        .defineInRange("Blind base duration", 3, 1, 60);

    private static final ForgeConfigSpec.IntValue CONFUSE_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Confuse enchantment to trigger.")
        .defineInRange("Confuse base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue CONFUSE_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Confuse enchantment in seconds.")
        .defineInRange("Confuse base duration", 3, 1, 60);

    private static final ForgeConfigSpec.IntValue CURSE_OF_SLOWNESS_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Curse Of Slowness enchantment to trigger.")
        .defineInRange("Curse Of Slowness base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue CURSE_OF_SLOWNESS_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Curse Of Slowness enchantment in seconds.")
        .defineInRange("Curse Of Slowness base duration", 3, 1, 60);

    private static final ForgeConfigSpec.IntValue EXECUTE_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Execute enchantment to trigger.")
        .defineInRange("Execute base chance", 1, 1, 20);

    private static final ForgeConfigSpec.IntValue HARM_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Harm enchantment to trigger.")
        .defineInRange("Harm base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue HARM_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Harm enchantment in seconds.")
        .defineInRange("Harm base duration", 3, 1, 60);

    private static final ForgeConfigSpec.IntValue LEVITATE_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Levitate enchantment to trigger.")
        .defineInRange("Levitate base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue LEVITATE_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Levitate enchantment in seconds.")
        .defineInRange("Levitate base duration", 3, 1, 60);

    private static final ForgeConfigSpec.IntValue LIFE_STEAL_BASE_RATIO_CONFIG = BUILDER
		.comment("Base damage-to-heal conversion ratio for Life Steal enchantment.")
        .defineInRange("Life Steal base ratio", 5, 1, 20);

    private static final ForgeConfigSpec.IntValue LIGHTNING_STRIKER_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Lightning Striker enchantment to trigger.")
        .defineInRange("Lightning Striker base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue LIGHTNING_STRIKER_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Lightning Striker enchantment in seconds.")
        .defineInRange("Lightning Striker base duration", 3, 1, 60);;

    private static final ForgeConfigSpec.IntValue POISON_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Poison enchantment to trigger.")
        .defineInRange("Poison base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue POISON_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Poison enchantment in seconds.")
        .defineInRange("Poison base duration", 3, 1, 60);

    private static final ForgeConfigSpec.IntValue SLOW_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Slow enchantment to trigger.")
        .defineInRange("Slow base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue SLOW_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Slow enchantment in seconds.")
        .defineInRange("Slow base duration", 3, 1, 60);;
    
    private static final ForgeConfigSpec.IntValue STARVE_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Starve enchantment to trigger.")
        .defineInRange("Starve base chance", 5, 1, 20);

    private static final ForgeConfigSpec.IntValue STARVE_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Starve enchantment in seconds.")
        .defineInRange("Starve base duration", 3, 1, 60);;
    
    private static final ForgeConfigSpec.IntValue TEMPO_THEFT_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Tempo Theft enchantment to trigger.")
        .defineInRange("Tempo Theft base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue TEMPO_THEFT_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Tempo Theft enchantment in seconds.")
        .defineInRange("Tempo Theft base duration", 3, 1, 60);;
    
    private static final ForgeConfigSpec.IntValue WEAKEN_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Weaken enchantment to trigger.")
        .defineInRange("Weaken base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue WEAKEN_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Weaken enchantment in seconds.")
        .defineInRange("Weaken base duration", 3, 1, 60);;

    private static final ForgeConfigSpec.IntValue WITHERING_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Withering enchantment to trigger.")
        .defineInRange("Withering base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue WITHERING_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Withering enchantment in seconds.")
        .defineInRange("Withering base duration", 3, 1, 60);
    
    private static final ForgeConfigSpec.IntValue STUN_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Stun enchantment to trigger.")
        .defineInRange("Stun base chance", 5, 1, 20);;
        
    private static final ForgeConfigSpec.IntValue STUN_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Stun enchantment in seconds.")
        .defineInRange("Stun base duration", 3, 1, 60);;
    
    private static final ForgeConfigSpec.IntValue DISARM_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Disarm enchantment to trigger.")
        .defineInRange("Disarm base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue ILLAGERS_BANE_BASE_MULTIPLIER_CONFIG = BUILDER
		.comment("Base multiplier for Illager's Bane enchantment.")
        .defineInRange("Illager's Bane base multiplier", 3, 1, 10);
    
    private static final ForgeConfigSpec.IntValue NETHER_SLAYER_BASE_MULTIPLIER_CONFIG = BUILDER
		.comment("Base multiplier for Nether Slayer enchantment.")
        .defineInRange("Nether Slayer base multiplier", 3, 1, 10);
    
    private static final ForgeConfigSpec.IntValue PILLAGING_BASE_MULTIPLIER_CONFIG = BUILDER
		.comment("Base multiplier for Pillaging enchantment.")
        .defineInRange("Pillaging base multiplier", 3, 1, 10);;
    
    private static final ForgeConfigSpec.IntValue RAMPAGE_BASE_CHANCE_CONFIG = BUILDER
		.comment("Base chance for Rampage enchantment to trigger.")
        .defineInRange("Rampage base chance", 5, 1, 20);
    
    private static final ForgeConfigSpec.IntValue RAMPAGE_BASE_DURATION_CONFIG = BUILDER
		.comment("Base duration for Rampage enchantment in seconds.")
        .defineInRange("Rampage base duration", 3, 1, 60);;
    
    private static final ForgeConfigSpec.IntValue EXPLORATION_BASE_PERCENTAGE_INCREMENT_CONFIG = BUILDER
		.comment("Base percentage increment for Exploration enchantment.")
        .defineInRange("Exploration base multiplier", 20, 1, 100);
    
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int EXECUTE_BASE_CHANCE;
    public static int LIFE_STEAL_BASE_RATIO;
    
    public static int WITHERING_BASE_CHANCE;
    public static int WITHERING_BASE_DURATION;
    
    public static int POISON_BASE_CHANCE;
    public static int POISON_BASE_DURATION;
    
    public static int BLIND_BASE_CHANCE;
    public static int BLIND_BASE_DURATION;
    
    public static int CONFUSE_BASE_CHANCE;
    public static int CONFUSE_BASE_DURATION;
    
    public static int CURSE_OF_SLOWNESS_BASE_CHANCE;
    public static int CURSE_OF_SLOWNESS_BASE_DURATION;
    
    public static int HARM_BASE_CHANCE;
    public static int HARM_BASE_DURATION;
    
    public static int LEVITATE_BASE_CHANCE;
    public static int LEVITATE_BASE_DURATION;
    
    public static int LIGHTNING_STRIKER_BASE_CHANCE;
    public static int LIGHTNING_STRIKER_BASE_DURATION;
    
    public static int SLOW_BASE_CHANCE;
    public static int SLOW_BASE_DURATION;
    
    public static int STARVE_BASE_CHANCE;
    public static int STARVE_BASE_DURATION;
    
    public static int TEMPO_THEFT_BASE_CHANCE;
    public static int TEMPO_THEFT_BASE_DURATION;
    
    public static int WEAKEN_BASE_CHANCE;
    public static int WEAKEN_BASE_DURATION;
    
    public static int STUN_BASE_CHANCE;
    public static int STUN_BASE_DURATION;
    
    public static int DISARM_BASE_CHANCE;
    
    public static int ILLAGERS_BANE_BASE_MULTIPLIER;
    public static int NETHER_SLAYER_BASE_MULTIPLIER;
    public static int PILLAGING_BASE_MULTIPLIER;

    public static int RAMPAGE_BASE_CHANCE;
    public static int RAMPAGE_BASE_DURATION;
    
    public static int EXPLORATION_BASE_PERCENTAGE_INCREMENT;
    
    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event)
    {
    	BLIND_BASE_CHANCE = BLIND_BASE_CHANCE_CONFIG.get();
    	BLIND_BASE_DURATION = BLIND_BASE_DURATION_CONFIG.get();

    	CONFUSE_BASE_CHANCE = CONFUSE_BASE_CHANCE_CONFIG.get();
    	CONFUSE_BASE_DURATION = CONFUSE_BASE_DURATION_CONFIG.get();

    	CURSE_OF_SLOWNESS_BASE_CHANCE = CURSE_OF_SLOWNESS_BASE_CHANCE_CONFIG.get();
    	CURSE_OF_SLOWNESS_BASE_DURATION = CURSE_OF_SLOWNESS_BASE_DURATION_CONFIG.get();

    	EXECUTE_BASE_CHANCE = EXECUTE_BASE_CHANCE_CONFIG.get();

    	HARM_BASE_CHANCE = HARM_BASE_CHANCE_CONFIG.get();
    	HARM_BASE_DURATION = HARM_BASE_DURATION_CONFIG.get();

    	LEVITATE_BASE_CHANCE = LEVITATE_BASE_CHANCE_CONFIG.get();
    	LEVITATE_BASE_DURATION = LEVITATE_BASE_DURATION_CONFIG.get();

    	LIFE_STEAL_BASE_RATIO = LIFE_STEAL_BASE_RATIO_CONFIG.get();
    	
    	LIGHTNING_STRIKER_BASE_CHANCE = LIGHTNING_STRIKER_BASE_CHANCE_CONFIG.get();
    	LIGHTNING_STRIKER_BASE_DURATION = LIGHTNING_STRIKER_BASE_DURATION_CONFIG.get();
    	
    	POISON_BASE_CHANCE = POISON_BASE_CHANCE_CONFIG.get();
    	POISON_BASE_DURATION = POISON_BASE_DURATION_CONFIG.get();
    	
    	SLOW_BASE_CHANCE = SLOW_BASE_CHANCE_CONFIG.get();
    	SLOW_BASE_DURATION = SLOW_BASE_DURATION_CONFIG.get();
    	
    	STARVE_BASE_CHANCE = STARVE_BASE_CHANCE_CONFIG.get();
    	STARVE_BASE_DURATION = STARVE_BASE_DURATION_CONFIG.get();
    	
    	TEMPO_THEFT_BASE_CHANCE = TEMPO_THEFT_BASE_CHANCE_CONFIG.get();
    	TEMPO_THEFT_BASE_DURATION = TEMPO_THEFT_BASE_DURATION_CONFIG.get();
    	
    	WEAKEN_BASE_CHANCE = WEAKEN_BASE_CHANCE_CONFIG.get();
    	WEAKEN_BASE_DURATION = WEAKEN_BASE_DURATION_CONFIG.get();
    	
    	WITHERING_BASE_CHANCE = WITHERING_BASE_CHANCE_CONFIG.get();
    	WITHERING_BASE_DURATION = WITHERING_BASE_DURATION_CONFIG.get();
    	
    	STUN_BASE_CHANCE = STUN_BASE_CHANCE_CONFIG.get();
    	STUN_BASE_DURATION = STUN_BASE_DURATION_CONFIG.get();
    	
    	DISARM_BASE_CHANCE = DISARM_BASE_CHANCE_CONFIG.get();
    	
    	ILLAGERS_BANE_BASE_MULTIPLIER = ILLAGERS_BANE_BASE_MULTIPLIER_CONFIG.get();
    	NETHER_SLAYER_BASE_MULTIPLIER = NETHER_SLAYER_BASE_MULTIPLIER_CONFIG.get();
    	PILLAGING_BASE_MULTIPLIER = PILLAGING_BASE_MULTIPLIER_CONFIG.get();
	
     	RAMPAGE_BASE_CHANCE = RAMPAGE_BASE_CHANCE_CONFIG.get();
    	RAMPAGE_BASE_DURATION = RAMPAGE_BASE_DURATION_CONFIG.get();
    	
    	EXPLORATION_BASE_PERCENTAGE_INCREMENT = EXPLORATION_BASE_PERCENTAGE_INCREMENT_CONFIG.get();
    }
}
