package darkrp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class wizytowkaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(args.length > 0) {
                Player target = Bukkit.getPlayerExact(args[0]);

                File f = new File("plugins/DarkRP/gracze.yml");
                YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);

                Boolean jest = (yamlFile.getBoolean(p.getName() + ".jest"));
                if(jest == true){

                    String imie = (yamlFile.getString(p.getName() + ".imie"));
                    String nazwisko = (yamlFile.getString(p.getName() + ".nazwisko"));
                    String zawod = (yamlFile.getString(p.getName() + ".zawod"));
                    int wiek = (yamlFile.getInt(p.getName() + ".wiek"));

                    target.sendMessage(ChatColor.YELLOW + "Dowód osobisty gracza " + ChatColor.RED + p.getName() + ChatColor.GOLD +
                            "\nImie i nazwisko: " + ChatColor.RED + imie +" "+nazwisko + ChatColor.GOLD +
                            "\nWiek: " + ChatColor.RED + wiek + ChatColor.GOLD +
                            "\nZawód: "+ ChatColor.RED +zawod);
                } else{
                    p.sendMessage(ChatColor.RED + "Nie masz wyrobionego dowodu osobistego!");
                }
            }else{
                p.sendMessage(ChatColor.RED + "Musisz wybrać osobe ktorej chcesz dać wizytowke!");
            }
        }else{
            System.out.println("Komenda tylko dla graczy!");
        }
        return false;
    }
}
