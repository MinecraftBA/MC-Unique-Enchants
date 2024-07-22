package ba.minecraft.uniquemagic.common.capabilities.enchantments.stunned;

public class StunnedCapability implements IStunnedCapability {
    private double[] stunnedPosition = new double[3];

    @Override
    public void setStunnedPosition(double x, double y, double z) {
        stunnedPosition[0] = x;
        stunnedPosition[1] = y;
        stunnedPosition[2] = z;
    }

    @Override
    public double[] getStunnedPosition() {
        return stunnedPosition;
    }
}