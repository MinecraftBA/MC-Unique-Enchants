package ba.minecraft.uniquemagic.common.enchantments.weapon;

import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.base.ModEnchantment;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;

public class LightningStrikerEnchantment extends ModEnchantment {

	public LightningStrikerEnchantment() {
		super(ItemTags.WEAPON_ENCHANTABLE, 2, 5, Enchantment.constantCost(25), Enchantment.dynamicCost(5, 8), 4, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
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

		// Cast attacker to player.
		Player player = (Player)attacker;

		// Calculate proc chance - 3% for every level of enchantment.
		int hitChance = enchantmentLevel * UniqueMagicModConfig.LIGHTNING_STRIKER_BASE_CHANCE;
		
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
		
		// Spawn lightning bolt at mob's location.
		EntityType.LIGHTNING_BOLT.spawn(serverLevel, null, player, targetPosition, MobSpawnType.TRIGGERED, true, true);
	}

	@Override
	protected String getBaseName() {
		return "Lightning Striker";
	}

}
