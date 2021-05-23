package darkrp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class payCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(args.length < 2) {
                p.sendMessage(ChatColor.RED + "Nie wybrałeś osoby której chcesz zapłacić lub nie określiłeś kwoty");
            }else {
                Player target = Bukkit.getPlayerExact(args[0]);
                File f = new File ("plugins/DarkRP/gracze.yml");
                YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
                String imie = yamlFile.getString(p.getName()+".imie");
                String nazwisko = yamlFile.getString(p.getName()+".nazwisko");

                String imiet = yamlFile.getString(target.getName()+".imie");
                String nazwiskot = yamlFile.getString(target.getName()+".nazwisko");

                File fe = new File ("plugins/DarkRP/hajs.yml");
                YamlConfiguration yamlFile1 = YamlConfiguration.loadConfiguration(fe);
                int hajs = yamlFile1.getInt(p.getName());
                int wymiana = Integer.parseInt(args[1]);
                if(wymiana > hajs) {
                    p.sendMessage(ChatColor.RED+"Nie masz wystarczająco gotówki!");
                } else{
                    yamlFile1.set(p.getName(), yamlFile1.getInt(p.getName())-wymiana);
                    yamlFile1.set(target.getName(), yamlFile1.getInt(target.getName())+wymiana);

                    p.sendMessage(ChatColor.GREEN + "Przelałeś " + ChatColor.RED + wymiana+"$" + ChatColor.GREEN + " dla " + ChatColor.RED + imiet+" "+nazwiskot);
                    target.sendMessage(ChatColor.RED + imie +" "+nazwisko + ChatColor.GREEN + " przelał ci " + ChatColor.RED + wymiana+"$");
                    try {
                        yamlFile1.save(fe);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else System.out.println("Komenda tylko dla graczy");
        return false;
    }
}