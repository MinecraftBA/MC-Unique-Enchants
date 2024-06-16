package ba.minecraft.uniquemagic.common.core;

import ba.minecraft.uniquemagic.common.enchantments.ModEnchantments;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageTypes;

public final class ModRegistries {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DAMAGE_TYPE, DamageTypes::bootstrap)
            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap);
    
    public static HolderLookup.Provider createLookup() {
        RegistryAccess.Frozen frozenRegistryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
        HolderLookup.Provider lookupProvider = BUILDER.build(frozenRegistryAccess);
        return lookupProvider;
    }
    
}
