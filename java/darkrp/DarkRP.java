package darkrp;

import jdk.nashorn.internal.ir.Block;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.xml.stream.Location;

public final class DarkRP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("[DarkRP] Loaded core...");

        getCommand("med").setExecutor(new MedCommand());
        System.out.println("[DarkRP] Loaded /med command");

        getCommand("regulamin").setExecutor(new RegulaminCommand());
        System.out.println("[DarkRP] Loaded /regulamin command");

        getCommand("rp").setExecutor(new RpCommand());
        System.out.println("[DarkRP] Loaded /rp command");

        getCommand("discord").setExecutor(new DiscordCommand());
        System.out.println("[DarkRP] Loaded /discord command");

        getCommand("wymiana").setExecutor(new WymianaCommand());
        System.out.println("[DarkRP] Loaded /wymiana command");

        getCommand("set").setExecutor(new SetCommand());
        System.out.println("[DarkRP] Loaded /set command");

        getCommand("dowod").setExecutor(new DowodCommand());
        System.out.println("[DarkRP] Loaded /dowod command");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player p = event.getPlayer();
        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.AQUA + p.getName());
        p.sendMessage(
                ChatColor.YELLOW + "Witaj " + p.getName() + ChatColor.GREEN +
                        "\nSprawdź regulamin używając " + ChatColor.RED + "/regulamin" + ChatColor.GREEN +
                        "\nSprawdź zasady RolePlay używając " + ChatColor.RED + "/rp" + ChatColor.GREEN +
                        "\nDołacz na serwer discord używając " + ChatColor.RED + "/discord");
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 255));
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerLeave(PlayerQuitEvent event) {

        Player p = event.getPlayer();
        event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "-" + ChatColor.GRAY + "] " + ChatColor.AQUA + p.getName());
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = event.getEntity().getPlayer();
        String reason = event.getDeathMessage();
        event.setDeathMessage(ChatColor.RED + p.getName() + " nie żyje");
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        Player p = event.getPlayer();
        String reason = event.getReason();
        event.setReason(ChatColor.RED  + "Zostałeś wyrzucony z serwera DarkRP z powodu: " + ChatColor.YELLOW + reason + ChatColor.GREEN + "" +
                "\nJeżeli uważasz że zostałeś wyrzucony niesłusznie, skontaktuj się z nami przez discorda - " + ChatColor.RED + "\nhttps://discord.gg/ApfNsmGcJP");
        //event.get(ChatColor.RED + p.getName() + ChatColor.GREEN + " został wyrzucony z serwera DarkRP z powodu " + ChatColor.RED + reason);
    }
}