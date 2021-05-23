package darkrp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class invseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.isOp() != true) {
            p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Nie masz dostępu do tej komendy!");
        } else {
            if (args.length == 0) {
                p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Nikogo nie oznaczyłeś!");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                p.openInventory(target.getInventory());
            }
        }
        return false;
    }
}