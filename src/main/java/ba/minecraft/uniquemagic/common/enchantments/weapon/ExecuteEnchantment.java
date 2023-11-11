package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
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
				
				// Create variable to hold player information.
				Player player = null;
				
			
				
				// IF: Attacker is player.
				if(attacker instanceof Player) 
				{
					// Cast it to player.
					player = (Player)attacker;
					
				}
				
				if(target instanceof Zombie) 
				{
					
					// Calculate proc chance - 5% for every level of enchantment.
					int hitChance = enchantmentLevel * 3;
					
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
					
					ItemStack head = new ItemStack(Items.ZOMBIE_HEAD);
					target.kill();
					// Spawn lightning bolt at mob's location.
					EntityType.ITEM.spawn(serverLevel, head, player, targetPosition, MobSpawnType.TRIGGERED, true, true);
				}
				
				
			}
			
			@Override
			protected String getBaseName() {
				return "Execute";
			}
}
