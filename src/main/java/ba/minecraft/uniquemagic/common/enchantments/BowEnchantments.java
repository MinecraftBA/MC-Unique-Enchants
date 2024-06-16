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
	
    public static void bootstrap(BootstrapContext<Enchantment> context) {
    	
    	HolderGetter<Item> itemsRegistry = context.lookup(Registries.ITEM);
    	
    	registerTrigger(context, itemsRegistry);
    	
    }
    
    private static void registerTrigger(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.BOW_ENCHANTABLE), 
        		1,
        		1, 
        		Enchantment.constantCost(20), 
        		Enchantment.constantCost(50), 
        		8, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
        ModEnchantmentHelper.register(context, TRIGGER, builder);
    }
}

