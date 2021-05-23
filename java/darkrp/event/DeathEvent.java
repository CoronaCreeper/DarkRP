package darkrp.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeathEvent implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = event.getEntity().getPlayer();
        String reason = event.getDeathMessage();

        int x = p.getLocation().getBlockX();
        int y = p.getLocation().getBlockY();
        int z = p.getLocation().getBlockZ();

        event.setDeathMessage(ChatColor.RED + p.getName() + " nie żyje" + ChatColor.RED +"\n"+x+", "+y+", "+z);

        File f = new File("plugins/DarkRP/smierci.yml");
        YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
        yamlFile.set(p.getName() + ".martwy?", true);
        yamlFile.set(p.getName() + ".x", x);
        yamlFile.set(p.getName() + ".y", y);
        yamlFile.set(p.getName() + ".z", z);
        try {
            yamlFile.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void respawn(PlayerRespawnEvent event) {
        Player p = event.getPlayer();
        File f = new File("plugins/DarkRP/smierci.yml");
        YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
        int x = yamlFile.getInt(p.getName()+".x");
        int y = yamlFile.getInt(p.getName()+".y");
        int z = yamlFile.getInt(p.getName()+".z");
        event.setRespawnLocation(new Location(p.getWorld(), x, y, z));
    }
}