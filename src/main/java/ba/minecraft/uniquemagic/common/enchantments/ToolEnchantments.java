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

public final class ToolEnchantments {
	
    public static final ResourceKey<Enchantment> TIMBER = ModEnchantmentHelper.createResourceKey("timber");
	
    public static void bootstrap(BootstrapContext<Enchantment> context) {
    	
    	HolderGetter<Item> itemsRegistry = context.lookup(Registries.ITEM);
    	
    	registerTimber(context, itemsRegistry);
    }
    
    private static void registerTimber(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.AXES), 
        		2,
        		1, 
        		Enchantment.constantCost(20), 
        		Enchantment.constantCost(50), 
        		4, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
        ModEnchantmentHelper.register(context, TIMBER, builder);
    }
}
