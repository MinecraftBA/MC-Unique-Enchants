package ba.minecraft.uniquemagic.common.capabilities.enchantments.stunned;

import net.minecraft.world.phys.Vec3;

public interface IStunnedCapability {
    void setStunnedPosition(Vec3 position);
    Vec3 getStunnedPosition();
}