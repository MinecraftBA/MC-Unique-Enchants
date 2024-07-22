package ba.minecraft.uniquemagic.common.capabilities.enchantments;

import ba.minecraft.uniquemagic.common.capabilities.enchantments.stun.IStunCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public final class ModEnchantmentCapabilities {
    public static Capability<IStunCapability> STUN_CAPABILITY;

    public static void register() {
        STUN_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    }
}
