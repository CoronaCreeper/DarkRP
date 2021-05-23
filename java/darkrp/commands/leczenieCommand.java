package darkrp.commands;

import jdk.javadoc.internal.tool.Start;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import javax.xml.stream.events.StartDocument;
import java.io.File;
import java.io.IOException;

public class leczenieCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(args.length == 2) {
                Player target = Bukkit.getPlayerExact(args[0]);
                int kasa = Integer.parseInt(args[1]);
                File f = new File("plugins/DarkRP/smierci.yml");
                YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);

                File fe = new File("plugins/DarkRP/hajs.yml");
                YamlConfiguration yamlFile1 = YamlConfiguration.loadConfiguration(fe);

                Boolean cos = yamlFile.getBoolean(target.getName() + ".martwy?");
                if(cos == true) {


                    yamlFile.set(target.getName() + ".martwy?", false);
                    yamlFile1.set(target.getName(), yamlFile1.getInt(target.getName())-kasa);
                    p.sendMessage(ChatColor.GREEN + "Pomyślnie uleczono " + ChatColor.RED + p.getName());
                    target.sendMessage(ChatColor.GREEN + "Zostałeś uleczony. Twój portfel został obciążony kwotą " + ChatColor.RED + kasa+"$");
                    target.removePotionEffect(PotionEffectType.REGENERATION);
                    target.removePotionEffect(PotionEffectType.BLINDNESS);
                    try {
                        yamlFile1.save(fe);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        yamlFile.save(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else p.sendMessage(ChatColor.RED + "Wybrana osoba nie jest ranna!");
            } else p.sendMessage(ChatColor.RED + "Poprawne użycie - /ulecz nick koszt");
        }else System.out.println("Komenda tylko dla medykow");
        return false;
    }
}
