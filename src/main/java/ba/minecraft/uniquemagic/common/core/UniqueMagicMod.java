package ba.minecraft.uniquemagic.common.core;

import com.mojang.logging.LogUtils;

import ba.minecraft.uniquemagic.common.enchantments.ArmorEnchants;
import ba.minecraft.uniquemagic.common.enchantments.DiggerEnchants;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchants;
import ba.minecraft.uniquemagic.common.mobeffects.BeneficialMobEffects;
import ba.minecraft.uniquemagic.common.mobeffects.HarmfulMobEffects;
import ba.minecraft.uniquemagic.common.tags.ModEntityTypeTags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UniqueMagicMod.MODID)
public class UniqueMagicMod
{
    public static final String MODID = "uniquemagic";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public UniqueMagicMod()
    {
    	ModEntityTypeTags.init();
    	
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        WeaponEnchants.REGISTRY.register(modEventBus);
        DiggerEnchants.REGISTRY.register(modEventBus);
        ArmorEnchants.REGISTRY.register(modEventBus);
        
        HarmfulMobEffects.REGISTRY.register(modEventBus);
        BeneficialMobEffects.REGISTRY.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, UniqueMagicModConfig.SPEC, MODID + "-server.toml");
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Unique Magic loading...");
    }

    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event)
    {
        LOGGER.info("Unique Magic loaded!");
    }
    
    @SubscribeEvent
    public void onServerStopping(ServerStoppingEvent event)
    {
        LOGGER.info("Unique Magic unloading...");
    }

    @SubscribeEvent
    public void onServerStopped(ServerStoppedEvent event)
    {
        LOGGER.info("Unique Magic unloaded!");
    }
}
