package darkrp.Admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class onAdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(p.isOp() != true) {
            p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Nie masz dostępu do tej komendy!");
        } else {
            if (p.getGameMode() == GameMode.SPECTATOR) {
                p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Jesteś już w panelu admina");
            } else {
                p.sendMessage(ChatColor.DARK_AQUA + "Witaj w panelu administratora. Zostałeś zalogowany jako "
                        + ChatColor.RED + p.getName() + ChatColor.DARK_AQUA + "." +
                        "\nJestes teraz niewidoczny dla innych graczy. Aby wrócić jako gracz, użyj komendy /offadmin.");

                p.getInventory().setBoots(new ItemStack(Material.AIR));
                p.getInventory().setLeggings(new ItemStack(Material.AIR));
                p.getInventory().setChestplate(new ItemStack(Material.AIR));
                p.getInventory().setHelmet(new ItemStack(Material.AIR));

                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 34324231, 1, false, false));

                p.setPlayerListName("Dummy");

                p.setGameMode(GameMode.SPECTATOR);

                Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "-" + ChatColor.GRAY + "] " + ChatColor.AQUA + p.getName());
            }
        }
        return false;
    }
}
