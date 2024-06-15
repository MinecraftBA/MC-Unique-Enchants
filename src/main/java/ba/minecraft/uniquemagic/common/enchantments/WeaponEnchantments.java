package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantment.EnchantmentDefinition;

public final class WeaponEnchantments {

    public static final ResourceKey<Enchantment> BLIND = ModEnchantmentHelper.createResourceKey("blind");
    public static final ResourceKey<Enchantment> CONFUSE = ModEnchantmentHelper.createResourceKey("confuse");
    public static final ResourceKey<Enchantment> CURSE_OF_SLOWNESS = ModEnchantmentHelper.createResourceKey("curse_of_slowness");
    public static final ResourceKey<Enchantment> DISARM = ModEnchantmentHelper.createResourceKey("disarm");
    public static final ResourceKey<Enchantment> EXECUTE = ModEnchantmentHelper.createResourceKey("execute");
    public static final ResourceKey<Enchantment> HARM = ModEnchantmentHelper.createResourceKey("harm");
    public static final ResourceKey<Enchantment> ILLAGERS_BANE = ModEnchantmentHelper.createResourceKey("illagers_bane");
    public static final ResourceKey<Enchantment> LEVITATE = ModEnchantmentHelper.createResourceKey("levitate");
    public static final ResourceKey<Enchantment> LIFE_STEAL = ModEnchantmentHelper.createResourceKey("life_steal");
    public static final ResourceKey<Enchantment> LIGHTNING_STRIKER = ModEnchantmentHelper.createResourceKey("lightning_striker");
    public static final ResourceKey<Enchantment> NETHER_SLAYER = ModEnchantmentHelper.createResourceKey("nether_slayer");
    public static final ResourceKey<Enchantment> PILLAGING = ModEnchantmentHelper.createResourceKey("pillaging");
    public static final ResourceKey<Enchantment> POISON = ModEnchantmentHelper.createResourceKey("poison");
    public static final ResourceKey<Enchantment> RAMPAGE = ModEnchantmentHelper.createResourceKey("rampage");
    public static final ResourceKey<Enchantment> SLOW = ModEnchantmentHelper.createResourceKey("slow");
    public static final ResourceKey<Enchantment> STARVE = ModEnchantmentHelper.createResourceKey("starve");
    public static final ResourceKey<Enchantment> STUN = ModEnchantmentHelper.createResourceKey("stun");
    public static final ResourceKey<Enchantment> TEMPO_THEFT = ModEnchantmentHelper.createResourceKey("tempo_theft");
    public static final ResourceKey<Enchantment> WEAKEN = ModEnchantmentHelper.createResourceKey("weaken");
    public static final ResourceKey<Enchantment> WITHERING = ModEnchantmentHelper.createResourceKey("withering");

    public static void bootstrap(BootstrapContext<Enchantment> context) {
    	
    	HolderGetter<Item> itemsRegistry = context.lookup(Registries.ITEM);
    	
    	registerDisarm(context, itemsRegistry);
    	registerLifeSteal(context, itemsRegistry);

    }
    
    private static void registerDisarm(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		1,
        		5, 
        		Enchantment.constantCost(25), 
        		Enchantment.constantCost(50), 
        		8, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
        ModEnchantmentHelper.register(context, DISARM, builder);
    }
    
    private static void registerLifeSteal(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		2,
        		5, 
        		Enchantment.constantCost(25), 
        		Enchantment.constantCost(50), 
        		4, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
        ModEnchantmentHelper.register(context, LIFE_STEAL, builder);
    }
}

