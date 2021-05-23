package darkrp.commands;

import jdk.nashorn.internal.ir.Block;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.xml.stream.Location;

public class buyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
        } else System.out.println("Komenda tylko dla graczy");

        return false;
    }
}
