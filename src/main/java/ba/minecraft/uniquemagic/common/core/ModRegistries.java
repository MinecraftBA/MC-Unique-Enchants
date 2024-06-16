package ba.minecraft.uniquemagic.common.core;

import ba.minecraft.uniquemagic.common.enchantments.ModEnchantments;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.data.worldgen.NoiseData;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.data.worldgen.StructureSets;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.data.worldgen.biome.BiomeData;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.network.chat.ChatType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.animal.WolfVariants;
import net.minecraft.world.entity.decoration.PaintingVariants;
import net.minecraft.world.item.JukeboxSongs;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.item.armortrim.TrimPatterns;
import net.minecraft.world.item.enchantment.providers.VanillaEnchantmentProviders;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterLists;
import net.minecraft.world.level.block.entity.BannerPatterns;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorPresets;
import net.minecraft.world.level.levelgen.presets.WorldPresets;

public final class ModRegistries {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, DimensionTypes::bootstrap)
            .add(Registries.CONFIGURED_CARVER, (RegistrySetBuilder.RegistryBootstrap)Carvers::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap)FeatureUtils::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacementUtils::bootstrap)
            .add(Registries.STRUCTURE, Structures::bootstrap)
            .add(Registries.STRUCTURE_SET, StructureSets::bootstrap)
            .add(Registries.PROCESSOR_LIST, ProcessorLists::bootstrap)
            .add(Registries.TEMPLATE_POOL, Pools::bootstrap)
            .add(Registries.BIOME, BiomeData::bootstrap)
            .add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, MultiNoiseBiomeSourceParameterLists::bootstrap)
            .add(Registries.NOISE, NoiseData::bootstrap)
            .add(Registries.DENSITY_FUNCTION, NoiseRouterData::bootstrap)
            .add(Registries.NOISE_SETTINGS, NoiseGeneratorSettings::bootstrap)
            .add(Registries.WORLD_PRESET, WorldPresets::bootstrap)
            .add(Registries.FLAT_LEVEL_GENERATOR_PRESET, FlatLevelGeneratorPresets::bootstrap)
            .add(Registries.CHAT_TYPE, ChatType::bootstrap)
            .add(Registries.TRIM_PATTERN, TrimPatterns::bootstrap)
            .add(Registries.TRIM_MATERIAL, TrimMaterials::bootstrap)
            .add(Registries.WOLF_VARIANT, WolfVariants::bootstrap)
            .add(Registries.PAINTING_VARIANT, PaintingVariants::bootstrap)
            .add(Registries.DAMAGE_TYPE, DamageTypes::bootstrap)
            .add(Registries.BANNER_PATTERN, BannerPatterns::bootstrap)
            .add(Registries.ENCHANTMENT_PROVIDER, VanillaEnchantmentProviders::bootstrap)
            .add(Registries.JUKEBOX_SONG, JukeboxSongs::bootstrap)
            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap);
    
    public static HolderLookup.Provider createLookup() {
        RegistryAccess.Frozen frozenRegistryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
        HolderLookup.Provider lookupProvider = BUILDER.build(frozenRegistryAccess);
        return lookupProvider;
    }
    
}
