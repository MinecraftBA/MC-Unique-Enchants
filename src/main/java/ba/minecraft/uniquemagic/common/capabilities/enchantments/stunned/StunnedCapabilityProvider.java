package ba.minecraft.uniquemagic.common.capabilities.enchantments.stunned;

import ba.minecraft.uniquemagic.common.capabilities.enchantments.ModEnchantmentCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.Vec3;
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
        Vec3 pos = capability.getStunnedPosition();
        tag.putDouble("stunnedX", pos.x());
        tag.putDouble("stunnedY", pos.y());
        tag.putDouble("stunnedZ", pos.z());
        return tag;
	}

	@Override
	public void deserializeNBT(Provider registryAccess, CompoundTag nbt) {
		double x = nbt.getDouble("stunnedX");
		double y = nbt.getDouble("stunnedY");
		double z = nbt.getDouble("stunnedZ");
		Vec3 position = new Vec3(x, y, z);
        capability.setStunnedPosition(position);
	}
}