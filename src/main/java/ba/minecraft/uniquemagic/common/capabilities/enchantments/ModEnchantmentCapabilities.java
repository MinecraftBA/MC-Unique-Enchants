package ba.minecraft.uniquemagic.common.capabilities.enchantments;

import ba.minecraft.uniquemagic.common.capabilities.enchantments.stunned.IStunnedCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public final class ModEnchantmentCapabilities {
    public static Capability<IStunnedCapability> STUNNED_CAPABILITY;

    public static void register() {
        STUNNED_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    }
}
