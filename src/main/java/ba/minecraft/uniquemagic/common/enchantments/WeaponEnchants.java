package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.weapon.BlindEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.ConfuseEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.CurseOfSlownessEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.DisarmEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.ExecuteEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.HarmEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.LevitateEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.LifeStealEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.LightningStrikerEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.PoisonEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.SlowEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.StarveEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.StunEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.TempoTheftEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.WeakenEnchantment;
import ba.minecraft.uniquemagic.common.enchantments.weapon.WitheringEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WeaponEnchants {

	public static final DeferredRegister<Enchantment> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UniqueMagicMod.MODID);
		
	public static final RegistryObject<Enchantment> LEVITATE = 
			REGISTRY.register("levitate",  () -> new LevitateEnchantment());
	
	public static final RegistryObject<Enchantment> POISON = 
			REGISTRY.register("poison",  () -> new PoisonEnchantment());
	
	public static final RegistryObject<Enchantment> STARVE = 
			REGISTRY.register("starve",  () -> new StarveEnchantment());
	
	public static final RegistryObject<Enchantment> WEAKEN = 
			REGISTRY.register("weaken",  () -> new WeakenEnchantment());
	
	public static final RegistryObject<Enchantment> LIFE_STEAL = 
			REGISTRY.register("life_steal",  () -> new LifeStealEnchantment());
	
	public static final RegistryObject<Enchantment> HARM = 
			REGISTRY.register("harm",  () -> new HarmEnchantment());
	
	public static final RegistryObject<Enchantment> BLIND = 
			REGISTRY.register("blind",  () -> new BlindEnchantment());
	
	public static final RegistryObject<Enchantment> SLOW = 
			REGISTRY.register("slow",  () -> new SlowEnchantment());
	
	public static final RegistryObject<Enchantment> CONFUSE = 
			REGISTRY.register("confuse",  () -> new ConfuseEnchantment());
	
	public static final RegistryObject<Enchantment> WITHERING = 
			REGISTRY.register("withering",  () -> new WitheringEnchantment());
	
	public static final RegistryObject<Enchantment> LIGHTNING_STRIKER = 
			REGISTRY.register("lightning_striker",  () -> new LightningStrikerEnchantment());
	
	public static final RegistryObject<Enchantment> EXECUTE = 
			REGISTRY.register("execute",  () -> new ExecuteEnchantment());
	
	public static final RegistryObject<Enchantment> TEMPO_THEFT = 
			REGISTRY.register("tempo_theft",  () -> new TempoTheftEnchantment());
	
	public static final RegistryObject<Enchantment> CURSE_OF_SLOWNESS = 
			REGISTRY.register("curse_of_slowness",  () -> new CurseOfSlownessEnchantment());
	
	public static final RegistryObject<Enchantment> STUN = 
			REGISTRY.register("stun",  () -> new StunEnchantment());

	public static final RegistryObject<Enchantment> DISARM = 
			REGISTRY.register("disarm",  () -> new DisarmEnchantment());
}

