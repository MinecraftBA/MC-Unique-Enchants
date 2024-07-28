package ba.minecraft.uniquemagic.common.events.enchantments.bow;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.enchantments.BowEnchantments;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
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
		
		// IF: Projectile is not arrow.
		if(!(projectile instanceof AbstractArrow)) {
			
			// Do nothing.
			return;
		}

		// Cast projectile to arrow.
		AbstractArrow arrow = (AbstractArrow)projectile;

		// Get reference to owner of arrow.
		Entity owner = arrow.getOwner();
		
		// IF: Owner is not living entity.
		if (!(owner instanceof LivingEntity)) {

			// Do nothing.
			return;
		}
		
		// Cast owner to living entity.
		LivingEntity shooter = (LivingEntity) owner;

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

    	// Get reference to enchantment.
    	Holder<Enchantment> enchantment = ModEnchantmentHelper.getHolder(level, BowEnchantments.TRIGGER);

    	// Get enchantment level on helmet.
    	int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantment, weapon);

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
        	
        	// IF: Target is not an instance of a creeper.
        	if(!(target instanceof Creeper)) {
        		
        		// Do nothing.
        		return;
        	}
        	
        	// Try to cast entity as creeper.
        	Creeper creeper = (Creeper) target;
        	
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

        	// Clear TNT block from position where it was hit - otherwise it explodes twice.
        	level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 11);
        	
        	// Explode it.
        	tnt.onCaughtFire(blockState, level, blockPos, null, shooter);
        	
    		return;
    	}

    	
    }
	
}
