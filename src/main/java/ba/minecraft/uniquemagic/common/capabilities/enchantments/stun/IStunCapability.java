package ba.minecraft.uniquemagic.common.capabilities.enchantments.stun;

public interface IStunCapability {
    void setStunnedPosition(double x, double y, double z);
    double[] getStunnedPosition();
}