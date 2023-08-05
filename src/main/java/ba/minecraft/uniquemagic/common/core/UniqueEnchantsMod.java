package ba.minecraft.uniquemagic.common.core;

import com.mojang.logging.LogUtils;

import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchants;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UniqueEnchantsMod.MODID)
public class UniqueEnchantsMod
{
    public static final String MODID = "uniquemagic";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public UniqueEnchantsMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        WeaponEnchants.REGISTRY.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("Unique Enchants loading...");
    }
}
