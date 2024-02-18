package ba.minecraft.uniquemagic.common.event.enchantments.weapons;

import ba.minecraft.uniquemagic.common.core.UniqueMagicMod;
import ba.minecraft.uniquemagic.common.core.UniqueMagicModConfig;
import ba.minecraft.uniquemagic.common.enchantments.WeaponEnchants;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UniqueMagicMod.MODID, bus = Bus.FORGE)
public class IllagersBaneEventHandler {
	
	@SubscribeEvent
    public void onEntityDamageByEntity(LivingAttackEvent event) {
		// Get source of the damage.
				DamageSource damageSource = event.getSource();
				
				// Get reference to entity that caused the damage.
				Entity attacker = damageSource.getEntity();

				// IF: Attack was not done by entity.
				if (attacker == null) {
					return;
				}

				// Get reference to level where event has occurred.
				Level level = attacker.level();
				
				// IF: Code is executing on the client side.
				if (level.isClientSide()) {
					return;
				}

				// IF: Attacker was not player.
				if(!(attacker instanceof Player)) {
					return;
				}
        if (!(event.getEntity() instanceof Raider)) return;

        
        LivingEntity raider = event.getEntity();
     // Get item on head.
     		ItemStack weapon = ((Player) attacker).getItemBySlot(EquipmentSlot.MAINHAND);

     // Get level of enchantment player has on equipped items.
     		int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(WeaponEnchants.ILLAGERS_BANE.get(), (LivingEntity) attacker);
     				
     		// IF: Enchantment level is not at least 1;
     		if (enchantmentLevel < 1) {
     			return;
     		}
     		
     		// Get the amount of damage that was inflicted.
    		float damageDealt = event.getAmount();
     		
            double extraDamage = enchantmentLevel * UniqueMagicModConfig.ILLAGERS_BANE_BASE_DAMAGE; // Example: Level 1 = +2.5 damage, Level 2 = +5, etc.
            raider.hurt(damageSource,(float) (damageDealt + extraDamage));
        
    }
}
