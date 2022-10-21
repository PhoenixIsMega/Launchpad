package me.phoenixcantfly.launchpad;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if (e.getPlayer().getLocation().getBlock().getType().equals(Material.AIR) && new Location(e.getPlayer().getLocation().getWorld(), e.getPlayer().getLocation().getBlockX(), e.getPlayer().getLocation().getY() - 1, e.getPlayer().getLocation().getZ()).getBlock().getType().equals(Material.EMERALD_BLOCK)){
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.3).setY(1));
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, 0.7F, 0.75F);
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_WITHER_SHOOT, 0.4F, 0.55F);
            e.getPlayer().getLocation().getWorld().spawnParticle(Particle.CLOUD, e.getPlayer().getLocation(), 150, 0.2F, 1, 0.2F, 0.01F);
        }
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
}
