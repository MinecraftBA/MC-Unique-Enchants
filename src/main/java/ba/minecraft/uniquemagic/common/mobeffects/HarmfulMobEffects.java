package ba.minecraft.uniquemagic.common.mobeffects;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.mobeffects.harmful.StunnedMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class HarmfulMobEffects {
	
	public static final DeferredRegister<MobEffect> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UniqueMagicMod.MODID);
	
	public static final RegistryObject<MobEffect> STUNNED = 
			REGISTRY.register("stunned", () -> new StunnedMobEffect());
}
