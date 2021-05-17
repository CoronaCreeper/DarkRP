package darkrp;

import jdk.nashorn.internal.ir.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.EnderChest;

public class PlecakCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        p.openInventory(p.getEnderChest());
        return false;
    }
}
