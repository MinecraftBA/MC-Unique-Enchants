package ba.minecraft.uniquemagic.common.enchantments;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import ba.minecraft.uniquemagic.common.tags.ModEnchantmentTags;
import ba.minecraft.uniquemagic.common.tags.ModEntityTypeTags;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.Enchantment.EnchantmentDefinition;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;

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
    	HolderGetter<Enchantment> enchantmentsRegistry = context.lookup(Registries.ENCHANTMENT);

    	registerDisarm(context, itemsRegistry);
    	registerExecute(context, itemsRegistry);
    	registerLifeSteal(context, itemsRegistry);
    	registerStun(context, itemsRegistry);

    	registerIllagersBane(context, itemsRegistry, enchantmentsRegistry);
    	registerNetherSlayer(context, itemsRegistry, enchantmentsRegistry);
    	registerPillaging(context, itemsRegistry, enchantmentsRegistry);
    	
    	registerBlind(context, itemsRegistry, enchantmentsRegistry);
    	registerConfuse(context, itemsRegistry, enchantmentsRegistry);
    	registerHarm(context, itemsRegistry, enchantmentsRegistry);
    	registerLevitate(context, itemsRegistry, enchantmentsRegistry);
    	registerPoison(context, itemsRegistry, enchantmentsRegistry);
    	registerSlow(context, itemsRegistry, enchantmentsRegistry);
    	registerStarve(context, itemsRegistry, enchantmentsRegistry);
    	registerWeaken(context, itemsRegistry, enchantmentsRegistry);
    	registerWithering(context, itemsRegistry, enchantmentsRegistry);

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
    
    private static void registerIllagersBane(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), 
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 8), 
        		Enchantment.dynamicCost(25,8), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that boost attack damage.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE));

    	// Condition under which damage attack boost effect will be applied.
    	LootItemCondition.Builder condition = LootItemEntityPropertyCondition.hasProperties(
                LootContext.EntityTarget.THIS, 
                EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(EntityTypeTags.ILLAGER))
        );

    	// Add instance damage boost effect.
        builder.withEffect(
            EnchantmentEffectComponents.DAMAGE,
            new AddValue(LevelBasedValue.perLevel(UniqueMagicModConfig.ILLAGERS_BANE_BASE_MULTIPLIER)),
            condition
        );
    	
        ModEnchantmentHelper.register(context, ILLAGERS_BANE, builder);
    }
    
    private static void registerNetherSlayer(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), 
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 8), 
        		Enchantment.dynamicCost(25,8), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that boost attack damage.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE));

    	// Condition under which damage attack boost effect will be applied.
    	LootItemCondition.Builder condition = LootItemEntityPropertyCondition.hasProperties(
                LootContext.EntityTarget.THIS, 
                EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(ModEntityTypeTags.NETHER_MOBS))
        );

    	// Add instance damage boost effect.
        builder.withEffect(
            EnchantmentEffectComponents.DAMAGE,
            new AddValue(LevelBasedValue.perLevel(UniqueMagicModConfig.NETHER_SLAYER_BASE_MULTIPLIER)),
            condition
        );
    	
        ModEnchantmentHelper.register(context, NETHER_SLAYER, builder);
    }
    
    private static void registerPillaging(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), 
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 8), 
        		Enchantment.dynamicCost(25,8), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that boost attack damage.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE));

    	// Condition under which damage attack boost effect will be applied.
    	LootItemCondition.Builder condition = LootItemEntityPropertyCondition.hasProperties(
                LootContext.EntityTarget.THIS, 
                EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(ModEntityTypeTags.VILLAGE_INHABITANTS))
        );

    	// Add instance damage boost effect.
        builder.withEffect(
            EnchantmentEffectComponents.DAMAGE,
            new AddValue(LevelBasedValue.perLevel(UniqueMagicModConfig.PILLAGING_BASE_MULTIPLIER)),
            condition
        );
    	
        ModEnchantmentHelper.register(context, PILLAGING, builder);
    }
    
    private static void registerBlind(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, BLIND, builder);
    }
    
    private static void registerPoison(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, POISON, builder);
    }
    
    private static void registerWithering(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, WITHERING, builder);
    }
    
    private static void registerConfuse(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, CONFUSE, builder);
    }
    
    private static void registerHarm(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, HARM, builder);
    }
    
    private static void registerLevitate(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, LEVITATE, builder);
    }
    
    private static void registerSlow(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, SLOW, builder);
    }
    
    private static void registerStarve(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, STARVE, builder);
    }
    
    private static void registerWeaken(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry, HolderGetter<Enchantment> enchantmentsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		5,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		2, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
    	// Cannot be used with other enchantments that place buff on mob.
    	builder.exclusiveWith(enchantmentsRegistry.getOrThrow(ModEnchantmentTags.MOB_EFFECT_EXCLUSIVE));
    	
        ModEnchantmentHelper.register(context, WEAKEN, builder);
    }
    
    private static void registerStun(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
    	EnchantmentDefinition definition = Enchantment.definition(
        		itemsRegistry.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 
        		2,
        		5, 
        		Enchantment.dynamicCost(5, 10), 
        		Enchantment.dynamicCost(25, 10), 
        		4, 
        		EquipmentSlotGroup.MAINHAND
        );
    	
    	Enchantment.Builder builder = Enchantment.enchantment(definition);
    	
        ModEnchantmentHelper.register(context, STUN, builder);
    }
    
    private static void registerExecute(BootstrapContext<Enchantment> context, HolderGetter<Item> itemsRegistry) {
    	
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
    	
        ModEnchantmentHelper.register(context, EXECUTE, builder);
    }
}

