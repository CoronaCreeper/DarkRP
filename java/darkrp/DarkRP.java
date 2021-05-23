package darkrp;

import darkrp.commands.Admin.offAdminCommand;
import darkrp.commands.Admin.onAdminCommand;
import darkrp.commands.*;
import darkrp.event.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DarkRP extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
        this.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        this.getServer().getPluginManager().registerEvents(new moveEvent(), this);




        getConfig().addDefault("domyslny_hajs","15000");
        getConfig().options().copyDefaults(true);
        saveConfig();

        System.out.println("[DarkRP] Loaded core...");

        getCommand("med").setExecutor(new MedCommand());
        System.out.println("[DarkRP] Loaded /med command");

        getCommand("regulamin").setExecutor(new RegulaminCommand());
        System.out.println("[DarkRP] Loaded /regulamin command");

        getCommand("rp").setExecutor(new RpCommand());
        System.out.println("[DarkRP] Loaded /rp command");

        getCommand("discord").setExecutor(new DiscordCommand());
        System.out.println("[DarkRP] Loaded /discord command");

        getCommand("onAdmin").setExecutor(new onAdminCommand());
        System.out.println("[DarkRP] Loaded /onAdmin command");

        getCommand("offAdmin").setExecutor(new offAdminCommand());
        System.out.println("[DarkRP] Loaded /offAdmin command");

        getCommand("plecak").setExecutor(new PlecakCommand());
        System.out.println("[DarkRP] Loaded /plecak command");

        getCommand("invsee").setExecutor(new darkrp.invseeCommand());
        System.out.println("[DarkRP] Loaded /invsee command");

        getCommand("stworzdowod").setExecutor(new stworzdowodCommand());
        System.out.println("[DarkRP] Loaded /stworzdowd command");

        getCommand("wizytowka").setExecutor(new wizytowkaCommand());
        System.out.println("[DarkRP] Loaded /wizytowka command");

        getCommand("pay").setExecutor(new payCommand());
        System.out.println("[DarkRP] Loaded /pay command");

        getCommand("buy").setExecutor(new buyCommand());
        System.out.println("[DarkRP] Loaded /buy command");

        getCommand("ulecz").setExecutor(new leczenieCommand());
        System.out.println("[DarkRP] Loaded /ulecz command");
    }
}