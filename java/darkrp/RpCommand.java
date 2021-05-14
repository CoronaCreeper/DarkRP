package darkrp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        p.sendMessage(ChatColor.GREEN + "Inicjacja - Słowne rozpoczęcie akcji w sposób zrozumiały dla drugiego gracza.\n ");
        p.sendMessage(ChatColor.GREEN + "In Character (IC) – wszystko w świecie gry.\n ");
        p.sendMessage(ChatColor.GREEN + "Out of Character (OOC) – wszystko spoza świata gry.\n ");
        p.sendMessage(ChatColor.GREEN + "Random Deathmatch (RDM) – zabijanie innych graczy bez żadnej inicjacji.\n ");
        p.sendMessage(ChatColor.GREEN + "Vehicle Deathmatch (VDM) – zabijanie innych bez inicjacji, używając do tego pojazdu..\n ");
        p.sendMessage(ChatColor.GREEN + "MetaGaming (MG) – wykorzystywanie informacji OOC do IC.\n ");
        p.sendMessage(ChatColor.GREEN + "Power Gaming (PG) – wymuszanie akcji RP na danym graczu, np:\n ");
        p.sendMessage(ChatColor.GREEN + "/me Przywołuje Batmana aby mu pomógł.\n ");
        p.sendMessage(ChatColor.GREEN + "/do Batman uderza tak mocno policjanta że umiera.\n ");
        p.sendMessage(ChatColor.GREEN + "Drive-By (DB) – strzelanie z pojazdu.\n ");
        p.sendMessage(ChatColor.GREEN + "Character Kill (CK) – permanentne uśmiercenie postaci.\n ");
        p.sendMessage(ChatColor.GREEN + "Force Charakter Kill (FCK) – permanentne uśmiercenie postaci narzucone przez szefa organizacji przestępczej, administrację etc.\n ");
        p.sendMessage(ChatColor.GREEN + "Fake Charakter Kill (FCK)- upozorowane uśmiercenie postaci po którym należy zmienić tożsamość, ubiór i wygląd, poparte mocna podstawa RP.\n ");
        p.sendMessage(ChatColor.GREEN + "Revenge Killing (RK) – zabijanie z zemsty.\n ");
        p.sendMessage(ChatColor.GREEN + "Brutally Wounded (BW) – stan nieprzytomności postaci.\n ");
        p.sendMessage(ChatColor.GREEN + "Cop Baiting (CB) – prowokowanie policji, aby zwrócić na siebie uwagę.\n ");
        p.sendMessage(ChatColor.GREEN + "Combat Log (CL) – celowe opuszczenie rozgrywki (serwera) podczas akcji RP.\n ");
        p.sendMessage(ChatColor.GREEN + "Komendy narracyjne.\n" +
                "- /me – opisuje czynności wykonywane przez twoją postać, np:\n" +
                "/me wyciąga telefon z kieszeni.\n" +
                "- /do – Opisuje stan danego przedmiotu bądź otoczenia postaci, np:\n" +
                "/do Plakat powiewa na wietrze.\n" +
                "/do Telefon ma niebieskie etui.\n " +
                "– /med – Opisuje zdrowie Twojej postaci, jest to komenda przystosowana do operacji, czy pomocy medycznych, np: /med Obywatel nieprzytomny.\n ");
        return false;
    }
}
