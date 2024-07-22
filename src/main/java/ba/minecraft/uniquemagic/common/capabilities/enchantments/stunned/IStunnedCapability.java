package ba.minecraft.uniquemagic.common.capabilities.enchantments.stunned;

public interface IStunnedCapability {
    void setStunnedPosition(double x, double y, double z);
    double[] getStunnedPosition();
}