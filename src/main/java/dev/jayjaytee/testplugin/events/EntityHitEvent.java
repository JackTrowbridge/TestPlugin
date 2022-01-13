package dev.jayjaytee.testplugin.events;

import de.tr7zw.nbtapi.NBTItem;
import dev.jayjaytee.testplugin.utils.DamageUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EntityHitEvent implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        if(!(event.getDamager() instanceof Player)) return;
        if(event.getEntity() instanceof ArmorStand) return;

        DamageUtils damageUtils = new DamageUtils();

        Entity victim = event.getEntity();
        Player damager = (Player) event.getDamager();

        int finalDamageAmount = 1;

        ItemStack damageItem = damager.getInventory().getItemInMainHand();
        if(!damageItem.getType().equals(Material.AIR)){
            NBTItem damageItemNBT = new NBTItem(damageItem);
            if(damageItemNBT.getInteger("damage") != 0) finalDamageAmount = damageItemNBT.getInteger("damage");
        }

        damageUtils.spawnDamageCounter(victim, finalDamageAmount);
        event.setDamage(finalDamageAmount);

        LivingEntity newVictim = (LivingEntity) victim;
        if(newVictim.getHealth() == 0) newVictim.setHealth(0);

    }

}
