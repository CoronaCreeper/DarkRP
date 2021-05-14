package darkrp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ZmianaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        String item = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        try {
            if (item != "cos") {
                p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.RED + "Nie trzymasz marichuany w głównej ręce");
            } else {
                int x = p.getLocation().getBlockX();
                int y = p.getLocation().getBlockY();
                int z = p.getLocation().getBlockZ();
                if (x != 1068) {
                    p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.DARK_RED + "Nie stoisz w wyznaczonym miejscu");
                } else {
                    if (y != 4) {
                        p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.DARK_RED + "Nie stoisz w wyznaczonym miejscu");
                    } else {
                        if (z != 920) {
                            p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.DARK_RED + "Nie stoisz w wyznaczonym miejscu");
                        } else {
                            ItemStack marichuana = p.getInventory().getItemInMainHand();
                            ItemStack blant = new ItemStack(Material.STICK, 1);
                            ItemMeta nozycetMeta = blant.getItemMeta();
                            nozycetMeta.setDisplayName(ChatColor.YELLOW + "Blancik");
                            nozycetMeta.addEnchant(Enchantment.MENDING, 1, true);
                            blant.setItemMeta(nozycetMeta);
                            p.getInventory().removeItem(marichuana);
                            p.getInventory().setItem(0, blant);
                            p.sendMessage(ChatColor.YELLOW + "[DarkRP] " + ChatColor.GREEN + "Wymieniono marichuane na blancika");
                        }
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }
}
