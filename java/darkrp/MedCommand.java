package darkrp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getName;

public class MedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
         if (args.length == 0) { // Command issued with no arguments
            p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Poprawne użycie - /med <nick do kogo chcesz wysłać> <tekst>. Pamiętaj że opis musi mieć tylko jeden wyraz!");
        } else {
                if (args[0] == p.getName()) {
                    p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Nie możesz wysłac wiadomości do siebie!");
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.GREEN + "Wysłano!");
                    target.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + p.getName() + ChatColor.GREEN + " mówi do ciebie: " + ChatColor.RED + args[1]);
                }
            }
        return false;
    }
}
