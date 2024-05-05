package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ExecuteEnchantment extends ModEnchantment{
	
    public ExecuteEnchantment() {
        super(ItemTags.WEAPON_ENCHANTABLE, 1, 5, Enchantment.constantCost(25), Enchantment.constantCost(50), 8, new EquipmentSlot[]{ EquipmentSlot.MAINHAND });
    }
	
	public void doPostAttack(LivingEntity attacker, Entity target, int enchantmentLevel) {

		// IF: Code is executing on the client.
		if (attacker.level().isClientSide()) {
			return;
		}

		// Get reference to world where event attack was done.
		ServerLevel serverLevel = (ServerLevel)attacker.level();
		
		// IF: Attacker is not player.
		if(!(attacker instanceof Player)) 
		{
			return;
		}
		
		// Variable to hold head type.
		Item headType = null;

		// IF: Target is zombie piglin.
		if(headType == null && target.getClass() == Piglin.class) {
			headType = Items.PIGLIN_HEAD;
		}

		// IF: Target is zombie.
		if(headType == null && target.getClass() == Zombie.class) {
			headType = Items.ZOMBIE_HEAD;
		}
		
		//IF:Target is wither skeleton
		if(headType == null && target.getClass() == WitherSkeleton.class) {
			headType = Items.WITHER_SKELETON_SKULL;
		}
		
		// IF: Target was Skeleton.
		if(headType == null && target.getClass() == Skeleton.class) {
			headType = Items.SKELETON_SKULL;
		}
		
		//IF: Target is creeper
		if(headType == null && target.getClass() == Creeper.class) {
			headType = Items.CREEPER_HEAD;
		}
		
		//IF: Target is player
		if(headType == null && target instanceof Player) {
			headType = Items.PLAYER_HEAD;
		}
		
		// IF: Head type is defined.
		if(headType != null) 
		{
			// Calculate proc chance - % for every level of enchantment.
			int hitChance = enchantmentLevel * UniqueMagicModConfig.EXECUTE_BASE_CHANCE;
			
			// Create random generator.
			RandomSource random = serverLevel.getRandom();
			
			// Get number between 0 and 99.
			int roll = random.nextInt(100);
			
			// IF: Apply on hit chance was missed.
			if (roll >= hitChance) {
				return;
			}
			
			// Get reference to position of mob that was attacked.
			BlockPos targetPosition = target.blockPosition();
			
			// Crate Zombie Head item stack.
			ItemStack head = new ItemStack(headType);

			// Create item entity for Zombie Head.
			ItemEntity headEntity = new ItemEntity(serverLevel, targetPosition.getX(), targetPosition.getY(), targetPosition.getZ(), head);
			
			// Add it to the world.
			serverLevel.addFreshEntity(headEntity);
			
			// Kill the target
			target.kill();
		}
	}
	
	@Override
	protected String getBaseName() {
		return "Execute";
	}
}
