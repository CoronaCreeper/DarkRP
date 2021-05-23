package darkrp.event;

import jdk.internal.loader.BuiltinClassLoader;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.*;

import javax.xml.stream.Location;
import java.io.File;

public class moveEvent implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();

        File fe = new File ("plugins/DarkRP/hajs.yml");
        YamlConfiguration yamlFile1 = YamlConfiguration.loadConfiguration(fe);
        int hajs = yamlFile1.getInt(p.getName());

        File f = new File ("plugins/DarkRP/gracze.yml");
        YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);

        String imie = yamlFile.getString(p.getName()+".imie");
        String nazwisko = yamlFile.getString(p.getName()+".nazwisko");
        String zawod = yamlFile.getString(p.getName()+".zawod");
        String wiek = yamlFile.getString(p.getName()+".wiek");
        yamlFile.set(p.getName() + ".imie", "nieustawiono");

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("Stats", "dummy");
        objective.setDisplayName(ChatColor.LIGHT_PURPLE + "Informacje");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);


        Score imie1 = objective.getScore(ChatColor.GOLD + "Imię: " + ChatColor.RED + imie);
        imie1.setScore(7);

        Score nazwisko1 = objective.getScore(ChatColor.GOLD + "Nazwisko: " + ChatColor.RED + nazwisko);
        nazwisko1.setScore(6);

        Score pustak = objective.getScore(" ");
        pustak.setScore(5);

        Score wiek1 = objective.getScore(ChatColor.GOLD + "Wiek: " + ChatColor.RED + wiek);
        wiek1.setScore(4);

        Score pustak1 = objective.getScore(" ");
        pustak1.setScore(3);

        Score zawod1 = objective.getScore(ChatColor.GOLD + "Zawód: " + ChatColor.RED + zawod);
        pustak1.setScore(2);

        Score konto = objective.getScore(ChatColor.GOLD + "Stan portfela: " + ChatColor.RED + hajs+"$");
        konto.setScore(1);
        p.setScoreboard(board);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();

        File f = new File("plugins/DarkRP/smierci.yml");
        YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
        Boolean cos = yamlFile.getBoolean(p.getName() + ".martwy?");
        if(cos == true) {
            p.teleport(p.getLocation());
            p.sendMessage(ChatColor.RED + "JESTEŚ RANNY! Wezwij pomoc, w przeciwnym wypadku sie wykrwawisz!");
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 53219, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 53219, 1));
        }
    }


}