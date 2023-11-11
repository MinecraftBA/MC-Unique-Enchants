package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ExecuteEnchantment extends ModEnchantment{
	
	public ExecuteEnchantment() {
		super(Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND});
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
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

		// IF: Target is zombie.
		if(target instanceof Zombie) 
		{
			// Calculate proc chance - 5% for every level of enchantment.
			int hitChance = enchantmentLevel * 3;
			
			// Create random generator.
			RandomSource random = serverLevel.getRandom();
			
			// TEMP OVERRIDE
			hitChance = 100;
			
			// Get number between 0 and 99.
			int roll = random.nextInt(100);
			
			// IF: Apply on hit chance was missed.
			if (roll >= hitChance) {
				return;
			}
			
			// Get reference to position of mob that was attacked.
			BlockPos targetPosition = target.blockPosition();
			
			// Crate Zombie Head item stack.
			ItemStack head = new ItemStack(Items.ZOMBIE_HEAD);

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
