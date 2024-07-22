package ba.minecraft.uniquemagic.common.capabilities.enchantments.stun;

import ba.minecraft.uniquemagic.common.capabilities.enchantments.ModEnchantmentCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class StunCapabilityProvider implements ICapabilitySerializable<CompoundTag> {
	
    private final StunCapability capability = new StunCapability();
    private final LazyOptional<IStunCapability> lazyOptional = LazyOptional.of(() -> capability);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == ModEnchantmentCapabilities.STUN_CAPABILITY ? lazyOptional.cast() : LazyOptional.empty();
    }

	@Override
	public CompoundTag serializeNBT(Provider registryAccess) {
        CompoundTag tag = new CompoundTag();
        double[] pos = capability.getStunnedPosition();
        tag.putDouble("stunX", pos[0]);
        tag.putDouble("stunY", pos[1]);
        tag.putDouble("stunZ", pos[2]);
        return tag;
	}

	@Override
	public void deserializeNBT(Provider registryAccess, CompoundTag nbt) {
        capability.setStunnedPosition(nbt.getDouble("stunX"), nbt.getDouble("stunY"), nbt.getDouble("stunZ"));
	}
}