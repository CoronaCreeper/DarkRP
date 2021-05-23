package darkrp.commands.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class offAdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(p.isOp() != true) {
            p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Nie masz dostępu do tej komendy!");
        } else {
            if (p.getGameMode() != GameMode.SPECTATOR) {
                p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Nie jesteś w panelu admina");
            } else {
                p.sendMessage(ChatColor.DARK_AQUA + "Zostałeś wylogowany z panelu admina");

                p.getInventory().setBoots(new ItemStack(Material.AIR));
                p.getInventory().setLeggings(new ItemStack(Material.AIR));
                p.getInventory().setChestplate(new ItemStack(Material.AIR));
                p.getInventory().setHelmet(new ItemStack(Material.AIR));

                p.removePotionEffect(PotionEffectType.INVISIBILITY);

                p.setPlayerListName(p.getName());

                p.setGameMode(GameMode.SURVIVAL);

                Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.AQUA + p.getName());
            }
        }
        return false;
    }
}
