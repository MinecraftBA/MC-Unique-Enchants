package ba.minecraft.uniquemagic.common.helpers;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import net.minecraft.resources.ResourceLocation;

public final class ModResourceLocation extends ResourceLocation {

	public ModResourceLocation(String path) {
		super(UniqueMagicMod.MODID, path);
	}

}
