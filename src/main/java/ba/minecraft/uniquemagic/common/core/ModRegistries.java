package ba.minecraft.uniquemagic.common.core;

import ba.minecraft.uniquemagic.common.enchantments.ModEnchantments;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class ModRegistries {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap);
    
}
