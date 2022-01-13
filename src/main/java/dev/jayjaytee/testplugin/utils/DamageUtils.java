package dev.jayjaytee.testplugin.utils;

import dev.jayjaytee.testplugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;

public class DamageUtils {

    public void spawnDamageCounter(Entity targetEntity, int amount){

        Location newLocation = targetEntity.getLocation().add(0, 2.1f, 0);

        ArmorStand armorStand = (ArmorStand) targetEntity.getWorld().spawn(newLocation, ArmorStand.class);

        armorStand.setGravity(false);
        armorStand.setCanPickupItems(false);
        armorStand.setCustomName( "§c-" + amount );
        armorStand.setCustomNameVisible(true);
        armorStand.setVisible(false);
        armorStand.setMarker(true);

        Bukkit.getScheduler().runTaskLater(TestPlugin.getInstance(), new Runnable() {
            @Override
            public void run() {
                armorStand.remove();
            }
        }, 8);

    }

}
