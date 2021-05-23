package darkrp.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;

public class stworzdowodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            File f = new File("plugins/DarkRP/gracze.yml");
            YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);

            Boolean jest = (yamlFile.getBoolean(p.getName() + ".jest"));
            String imie = (yamlFile.getString(p.getName() + ".imie"));
            String nazwisko = (yamlFile.getString(p.getName() + ".nazwisko"));
            int wiek = (yamlFile.getInt(p.getName() + ".wiek"));

            if (jest == false) {
                if (args.length < 3) {
                    p.sendMessage(ChatColor.RED + "Poprawne użycie komendy: " + ChatColor.GREEN + "/stworzdowod Imie Nazwisko Wiek");
                } else {
                    yamlFile.set(p.getName() + ".imie", args[0]);
                    yamlFile.set(p.getName() + ".nazwisko", args[1]);
                    yamlFile.set(p.getName() + ".wiek", args[2]);
                    yamlFile.set(p.getName() + ".jest", true);
                    yamlFile.set(p.getName() + ".zawod", "bezrobotny");
                    try {
                        yamlFile.save(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    p.sendMessage(ChatColor.GREEN + "Utworzyłeś swój dowód!" + ChatColor.GOLD +
                            "\nImię i nazwisko: " + ChatColor.RED + args[0]+" "+ args[1]+ChatColor.GOLD +
                            "\nWiek: "+ChatColor.RED +args[2]);
                    p.removePotionEffect(PotionEffectType.SLOW);
                    p.removePotionEffect(PotionEffectType.REGENERATION);
                    p.removePotionEffect(PotionEffectType.BLINDNESS);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.setPlayerListName(imie);
                }
            } else p.sendMessage(ChatColor.RED + "Masz już ustawiony dowód!");
        }
        return false;
    }
}
