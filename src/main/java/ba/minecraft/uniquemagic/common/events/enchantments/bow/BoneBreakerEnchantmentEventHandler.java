package ba.minecraft.uniquemagic.common.events.enchantments.bow;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.BowEnchantments;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchantments;
import ba.minecraft.uniquemagic.common.helpers.ModEnchantmentHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public final class BoneBreakerEnchantmentEventHandler {

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
        ServerLevel serverLevel = (ServerLevel)level;
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
        	if(!(target instanceof Skeleton) || !(target instanceof WitherSkeleton)) {
        		
        		// Do nothing.
        		return;
        	}

    		// Variable to hold head type.
    		Item headType = null;

    		//IF:Target is wither skeleton
    		if(target.getClass() == WitherSkeleton.class) {
    			headType = Items.WITHER_SKELETON_SKULL;
    		}
    		
    		// IF: Target was Skeleton.
    		if(headType == null && target.getClass() == Skeleton.class) {
    			headType = Items.SKELETON_SKULL;
    		}

    		// IF: Head type was not determined.
    		if (headType == null) {
    			return;
    		}
    		
    		// Create random generator.
    		RandomSource random = level.getRandom();
    		
    		// Calculate proc chance - % for every level of enchantment.
    		int hitChance = enchantmentLevel * UniqueMagicModConfig.BONE_BREAKER_BASE_CHANCE;
    		
    		// Get number between 0 and 99.
    		int roll = random.nextInt(100);
    		
    		// IF: Apply on hit chance was missed.
    		if (roll >= hitChance) {
    			
    			// Do nothing.
    			return;
    		}
    		
    		// Get reference to position of mob that was attacked.
    		BlockPos targetPosition = target.blockPosition();
    		
    		// Crate head item stack.
    		ItemStack head = new ItemStack(headType);

    		// Create item entity for head.
    		ItemEntity headEntity = new ItemEntity(serverLevel, targetPosition.getX(), targetPosition.getY(), targetPosition.getZ(), head);
    		
    		// Add it to the world.
    	    serverLevel.addFreshEntity(headEntity);

    		for(int i = 0; i<4; i++) {

    			// Crate bone item stack.
    			ItemStack bone = new ItemStack(Items.BONE);

    			// Create item entity for bone.
    			ItemEntity boneEntity = new ItemEntity(serverLevel, targetPosition.getX(), targetPosition.getY(), targetPosition.getZ(), bone);

    			// Add it to the world 4x.
    			serverLevel.addFreshEntity(boneEntity);
    		}
    		
    		// Kill the target
    		target.kill();
    		return;
    	}

		
	}
}
