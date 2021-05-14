package darkrp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.xml.stream.Location;

public class WymianaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        public static boolean isMatBelow(Player p,  int depth) {
            Location location = p.getLocation().clone(); // Cloned location
            for (int blocks = 1; blocks <= depth; blocks++) { // From 1 to depth
                ((org.bukkit.Location) location).subtract(0, 1, 0); // Move one block down

        Location loc0 = (Location) p.getLocation();
        Location loc = (loc0.);

        int block = loc.getBlockType(loc)



        p.sendMessage(String.valueOf(block));
        //if(p.getLocation().getBlock().getType() == )


        return false;
    }
}