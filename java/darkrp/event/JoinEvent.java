package darkrp.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.File;
import java.io.IOException;

public class JoinEvent implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player p = event.getPlayer();
        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.AQUA + p.getName());
        p.sendMessage(
                ChatColor.YELLOW + "Witaj " + p.getName() + ChatColor.GREEN +
                        "\nSprawdź regulamin używając " + ChatColor.RED + "/regulamin" + ChatColor.GREEN +
                        "\nSprawdź zasady RolePlay używając " + ChatColor.RED + "/rp" + ChatColor.GREEN +
                        "\nDołacz na serwer discord używając " + ChatColor.RED + "/discord");
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 255));

        File fe = new File ("plugins/DarkRP/hajs.yml");
        YamlConfiguration yamlFile1 = YamlConfiguration.loadConfiguration(fe);
        if(yamlFile1.get(p.getName()) == null) {
            yamlFile1.set(p.getName(), 15000);
            try {
                yamlFile1.save(fe);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File f = new File ("plugins/DarkRP/gracze.yml");
        YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
        if(yamlFile.get(p.getName()+".jest") == null) {
            yamlFile.set(p.getName()+".jest", false);
        }
        if(yamlFile.getBoolean(p.getName()+".jest") == false) {
            yamlFile.set(p.getName() + ".imie", "nieustawiono");
            yamlFile.set(p.getName() + ".nazwisko", "nieustawiono");
            yamlFile.set(p.getName() + ".wiek", "nieustawiono");
            try {
                yamlFile.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            p.sendMessage(ChatColor.RED + "Utwórz dowód komendą !stworzdowod " +
                    "\nW przeciwnym wypadku zostaniesz wyrzucony z serwera!");
            p.removePotionEffect(PotionEffectType.REGENERATION);
            p.addPotionEffect((new PotionEffect(PotionEffectType.SLOW, 94545, 10, false)));
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3212, 10, false));
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 74354, 10, false));
            p.setGameMode(GameMode.ADVENTURE);
            p.setPlayerListName("Rejerstracja...");
        }else {
            String imie = yamlFile.getString(p.getName()+".imie");
            p.setPlayerListName(ChatColor.YELLOW + imie + ChatColor.GRAY+" >> ("+p.getName()+")");
        }
        }
    }
