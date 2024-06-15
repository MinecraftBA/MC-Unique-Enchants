package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import ba.minecraft.uniquemagic.common.tags.ModDamageTypeTags;
import ba.minecraft.uniquemagic.common.tags.ModEnchantmentTags;
import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.advancements.critereon.TagPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.Enchantment.EnchantmentDefinition;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.level.storage.loot.predicates.DamageSourceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public final class ArmorEnchantments {

    public static final ResourceKey<Enchantment> EXPLORATION = ModEnchantmentHelper.createResourceKey("exploration");
    public static final ResourceKey<Enchantment> FREEZING_PROTECTION = ModEnchantmentHelper.createResourceKey("freezing_protection");
    public static final ResourceKey<Enchantment> LIGHTNING_PROTECTION = ModEnchantmentHelper.createResourceKey("lightning_protection");
    public static final ResourceKey<Enchantment> MAGIC_PROTECTION = ModEnchantmentHelper.createResourceKey("magic_protection");
    public static final ResourceKey<Enchantment> OMNIVORE = ModEnchantmentHelper.createResourceKey("omnivore");
    public static final ResourceKey<Enchantment> SONIC_PROTECTION = ModEnchantmentHelper.createResourceKey("sonic_protection");
    
    public static void bootstrap(BootstrapContext<Enchantment> context) {
    	
    	HolderGetter<Item> itemsRegistry = context.lookup(Registries.ITEM);
    	HolderGetter<Enchantment> enchantmentsRegistry = context.lookup(Registries.ENCHANTMENT);
    	
    	registerExploration(context, itemsRegistry, enchantmentsRegistry);
    	registerOmnivore(context, itemsRegistry);

    	registerFreezingProtection(context, itemsRegistry, enchantmentsRegistry);
    	registerLightningProtection(context, itemsRegistry, enchantmentsRegistry);
    	registerMagicProtection(context, itemsRegistry, enchantmentsRegistry);
    	registerSonicProtection(context, itemsRegistry, enchantmentsRegistry);
    }
    
    private static void registerExploration(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.HEAD_ARMOR_ENCHANTABLE), 
        		1,
        		5, 
        		Enchantment.dynamicCost(1, 8), 
        		Enchantment.dynamicCost(21, 8), 
        		8, 
        		EquipmentSlotGroup.HEAD
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);

    	// Cannot be used with other enchantments that gain XP.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.XP_GAIN_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, EXPLORATION, builder);
    }
    
    private static void registerOmnivore(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.HEAD_ARMOR_ENCHANTABLE), 
        		2,
        		1, 
        		Enchantment.constantCost(20), 
        		Enchantment.constantCost(50), 
        		4, 
        		EquipmentSlotGroup.HEAD
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);

        ModEnchantmentHelper.register(context, OMNIVORE, builder);
    }
    
    private static void registerFreezingProtection(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.ARMOR_ENCHANTABLE), 
        		5,
        		4, 
        		Enchantment.dynamicCost(10,8), 
        		Enchantment.dynamicCost(18,8), 
        		2, 
        		EquipmentSlotGroup.ARMOR
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);

    	// Cannot be used with other enchantments that provide protection.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE));
    	
    	// Create condition for damage source that is mitigated.
    	DamageSourcePredicate.Builder damageSourceCondition = DamageSourcePredicate.Builder.damageType()
                .tag(TagPredicate.is(DamageTypeTags.IS_FREEZING))
                .tag(TagPredicate.isNot(DamageTypeTags.BYPASSES_INVULNERABILITY));
    	
    	// Create condition for effect to happen.
    	LootItemCondition.Builder effectCondition = DamageSourceCondition.hasDamageSource(damageSourceCondition);

    	// Add effect to enchantment.
    	builder.withEffect(
			EnchantmentEffectComponents.DAMAGE_PROTECTION, 
			new AddValue(LevelBasedValue.perLevel(UniqueMagicModConfig.FREEZING_PROTECTION_BASE_MULTIPLIER)),
			effectCondition
        );
    	
        ModEnchantmentHelper.register(context, FREEZING_PROTECTION, builder);
    }
    
    private static void registerLightningProtection(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.ARMOR_ENCHANTABLE), 
        		5,
        		4, 
        		Enchantment.dynamicCost(10,8), 
        		Enchantment.dynamicCost(18,8), 
        		2, 
        		EquipmentSlotGroup.ARMOR
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);

    	// Cannot be used with other enchantments that provide protection.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE));
    	
    	// Create condition for damage source that is mitigated.
    	DamageSourcePredicate.Builder damageSourceCondition = DamageSourcePredicate.Builder.damageType()
                .tag(TagPredicate.is(DamageTypeTags.IS_LIGHTNING))
                .tag(TagPredicate.isNot(DamageTypeTags.BYPASSES_INVULNERABILITY));
    	
    	// Create condition for effect to happen.
    	LootItemCondition.Builder effectCondition = DamageSourceCondition.hasDamageSource(damageSourceCondition);

    	// Add effect to enchantment.
    	builder.withEffect(
			EnchantmentEffectComponents.DAMAGE_PROTECTION, 
			new AddValue(LevelBasedValue.perLevel(UniqueMagicModConfig.LIGHTNING_PROTECTION_BASE_MULTIPLIER)),
			effectCondition
        );
    	
        ModEnchantmentHelper.register(context, LIGHTNING_PROTECTION, builder);
    }
    
    private static void registerMagicProtection(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.ARMOR_ENCHANTABLE), 
        		5,
        		4, 
        		Enchantment.dynamicCost(10,8), 
        		Enchantment.dynamicCost(18,8), 
        		2, 
        		EquipmentSlotGroup.ARMOR
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);

    	// Cannot be used with other enchantments that provide protection.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE));
    	
    	// Create condition for damage source that is mitigated.
    	DamageSourcePredicate.Builder damageSourceCondition = DamageSourcePredicate.Builder.damageType()
                .tag(TagPredicate.is(ModDamageTypeTags.MAGIC))
                .tag(TagPredicate.isNot(DamageTypeTags.BYPASSES_INVULNERABILITY));
    	
    	// Create condition for effect to happen.
    	LootItemCondition.Builder effectCondition = DamageSourceCondition.hasDamageSource(damageSourceCondition);

    	// Add effect to enchantment.
    	builder.withEffect(
			EnchantmentEffectComponents.DAMAGE_PROTECTION, 
			new AddValue(LevelBasedValue.perLevel(UniqueMagicModConfig.MAGIC_PROTECTION_BASE_MULTIPLIER)),
			effectCondition
        );
    	
        ModEnchantmentHelper.register(context, MAGIC_PROTECTION, builder);
    }
    
	private static void registerSonicProtection(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
	    	
	    	EnchantmentDefinition definition = Enchantment.definition(
	        		itemsRegistry.getOrThrow(ItemTags.ARMOR_ENCHANTABLE), 
	        		5,
	        		4, 
	        		Enchantment.dynamicCost(10,8), 
	        		Enchantment.dynamicCost(18,8), 
	        		2, 
	        		EquipmentSlotGroup.ARMOR
	        );
	    	
	    	Enchantment.Builder builder = Enchantment.enchantment(definition);
	
	    	// Cannot be used with other enchantments that provide protection.
	    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE));
	    	
	    	// Create condition for damage source that is mitigated.
	    	DamageSourcePredicate.Builder damageSourceCondition = DamageSourcePredicate.Builder.damageType()
	                .tag(TagPredicate.is(ModDamageTypeTags.SONIC))
	                .tag(TagPredicate.isNot(DamageTypeTags.BYPASSES_INVULNERABILITY));
	    	
	    	// Create condition for effect to happen.
	    	LootItemCondition.Builder effectCondition = DamageSourceCondition.hasDamageSource(damageSourceCondition);
	
	    	// Add effect to enchantment.
	    	builder.withEffect(
				EnchantmentEffectComponents.DAMAGE_PROTECTION, 
				new AddValue(LevelBasedValue.perLevel(UniqueMagicModConfig.SONIC_PROTECTION_BASE_MULTIPLIER)),
				effectCondition
	        );
	    	
	        ModEnchantmentHelper.register(context, SONIC_PROTECTION, builder);
	    }
	}
