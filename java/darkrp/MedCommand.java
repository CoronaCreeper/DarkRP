package darkrp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getName;

public class MedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        if (args.length == 0) { // Command issued with no arguments
            p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.GREEN + "Wyczyściłem twój opis");
        } else {
            p.setDisplayName(p.getName() + " (" + args + ")");
            p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.GREEN + "Ustawiłem twój opis na " + args);
        }
        return false;
    }
}
