package ba.minecraft.uniquemagic.common.capabilities.enchantments.stunned;

import ba.minecraft.uniquemagic.common.capabilities.enchantments.ModEnchantmentCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class StunnedCapabilityProvider implements ICapabilitySerializable<CompoundTag> {
	
    private final StunnedCapability capability = new StunnedCapability();
    private final LazyOptional<IStunnedCapability> lazyOptional = LazyOptional.of(() -> capability);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == ModEnchantmentCapabilities.STUNNED_CAPABILITY ? lazyOptional.cast() : LazyOptional.empty();
    }

	@Override
	public CompoundTag serializeNBT(Provider registryAccess) {
        CompoundTag tag = new CompoundTag();
        double[] pos = capability.getStunnedPosition();
        tag.putDouble("stunnedX", pos[0]);
        tag.putDouble("stunnedY", pos[1]);
        tag.putDouble("stunnedZ", pos[2]);
        return tag;
	}

	@Override
	public void deserializeNBT(Provider registryAccess, CompoundTag nbt) {
        capability.setStunnedPosition(nbt.getDouble("stunnedX"), nbt.getDouble("stunnedY"), nbt.getDouble("stunnedZ"));
	}
}