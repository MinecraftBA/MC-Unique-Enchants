package ba.minecraft.uniquemagic.common.event.enchantments.bow;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.BowEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class TriggerEnchantmentEventHandler {
	
	@SubscribeEvent
	public static void onProjectileImpact(final ProjectileImpactEvent event) {

		// Get reference to projectile.
		Projectile projectile = event.getProjectile();
		
		// Cast projectile to arrow.
		AbstractArrow arrow = (AbstractArrow)projectile;
		
		// IF: Projectile is not arrow.
		if(arrow == null) {
			
			// Do nothing.
			return;
		}

		// Get reference to owner of arrow.
		Entity owner = arrow.getOwner();
		
		// Cast owner to living entity.
		LivingEntity shooter = (LivingEntity) owner;
		
		// IF: Owner is not living entity.
		if(shooter == null) {

			// Do nothing.
			return;
		}

        // Get reference to level where code is executing.
        Level level = shooter.level();
        
        // IF: Code is executing on client side.
        if(level.isClientSide) {
        	
        	// Do nothing.
        	return;
        }

        // Get reference to bow that shooter is carrying.
    	ItemStack weapon = shooter.getItemBySlot(EquipmentSlot.MAINHAND);
        
    	// IF: Shooter is not carrying any item.
    	if(weapon == null) {
    		
    		// Do nothing.
    		return;
    	}

    	// Get enchantment level on helmet.
    	int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(BowEnchantments.TRIGGER.get(), weapon);

    	// IF: There is no enchantment.
    	if(enchantmentLevel == 0) {
    		
    		// Do nothing.
    		return;
    	}

    	// Get reference to what was hit.
    	HitResult hitResult = event.getRayTraceResult();

    	// IF: Entity was hit.
    	if(hitResult instanceof EntityHitResult entityHitResult) {

    		// Get reference to entity that was hit.
        	Entity target = entityHitResult.getEntity();
        	
        	// Try to cast entity as creeper.
        	Creeper creeper = (Creeper) target;

        	// IF: Target was not creeper.
        	if(creeper == null) {
        		
        		// Do nothing.
        		return;
        	}
        	
        	// Ignite creeper causing it to blow up.
    		creeper.ignite();

    		return;
    	}
    	
    	// IF: Block was hit.
    	if(hitResult instanceof BlockHitResult blockHitResult) {

    		// Get reference to position of block that was hit.
        	BlockPos blockPos = blockHitResult.getBlockPos();
        	
        	// Get reference to block instance.
        	BlockState blockState = level.getBlockState(blockPos);

        	// IF: Block is not TNT.
        	if(!blockState.is(Blocks.TNT)) {
        		
        		// Do nothing.
        		return;
        	}
        	
        	// Get reference to block.
        	TntBlock tnt = (TntBlock)blockState.getBlock();
        	
        	// Explode it.
        	tnt.explode(level, blockPos);
        	
    		return;
    	}

    	
    }
	
}
