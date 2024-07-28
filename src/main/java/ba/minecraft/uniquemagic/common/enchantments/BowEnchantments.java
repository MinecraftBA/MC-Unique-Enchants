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

public final class BowEnchantments {

    public static final ResourceKey<Enchantment> TRIGGER = ModEnchantmentHelper.createResourceKey("trigger");
    public static final ResourceKey<Enchantment> BONE_BREAKER = ModEnchantmentHelper.createResourceKey("bone_breaker");
    
    public static void bootstrap(BootstrapContext<Enchantment> context) {
    	
    	HolderGetter<Item> itemsRegistry = context.lookup(Registries.ITEM);
    	
    	registerTrigger(context, itemsRegistry);
    	registerBoneBreaker(context, itemsRegistry);
    	
    }
    
    private static void registerTrigger(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.BOW_ENCHANTABLE), 
        		1,
        		1, 
        		Enchantment.constantCost(20), // Taken from Infinity
        		Enchantment.constantCost(50),  // Taken from Infinity
        		8, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
        ModEnchantmentHelper.register(context, TRIGGER, builder);
    }
    
    private static void registerBoneBreaker(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.BOW_ENCHANTABLE), 
        		1,
        		5, 
        		Enchantment.dynamicCost(10, 20), // Taken from Thorns
        		Enchantment.dynamicCost(60, 20), // Taken from Thorns
        		8, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
        ModEnchantmentHelper.register(context, BONE_BREAKER, builder);
    }
}

