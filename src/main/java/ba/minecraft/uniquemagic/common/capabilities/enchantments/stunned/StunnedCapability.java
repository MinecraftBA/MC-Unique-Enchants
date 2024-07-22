package ba.minecraft.uniquemagic.common.capabilities.enchantments.stunned;

import net.minecraft.world.phys.Vec3;

public class StunnedCapability implements IStunnedCapability {

	private Vec3 stunnedPosition = new Vec3(0,0,0);

    @Override
    public void setStunnedPosition(Vec3 position) {
    	stunnedPosition = position;
    }

    @Override
    public Vec3 getStunnedPosition() {
        return stunnedPosition;
    }
}