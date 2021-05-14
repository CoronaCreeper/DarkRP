package darkrp;

import jdk.nashorn.internal.ir.Block;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.stream.Location;

public final class DarkRP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("[DarkRP] Loaded core...");

        getCommand("zmiana").setExecutor(new ZmianaCommand());
        System.out.println("[DarkRP] Loaded /zmiana command");

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
    }
}