package ba.minecraft.uniquemagic.common.helpers;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import net.minecraft.resources.ResourceLocation;

public final class ModResourceLocation {

	public static ResourceLocation create(String path) {
		return ResourceLocation.fromNamespaceAndPath(UniqueMagicMod.MODID, path);
	}

}
