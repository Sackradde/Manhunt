package me.Sackradde.Manhunt2;



import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;


public class ClickListener implements Listener {




    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();
        Player hunted = null;

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getMainScoreboard();
        Team huntedteam = scoreboard.getTeam("Hunted");

        for (Player player:Bukkit.getServer().getOnlinePlayers()
             ) {
            if (huntedteam.hasEntry(player.getName())){
                hunted = player;
            }
        }

        if (hunted == null){Bukkit.broadcastMessage("No Hunted detected!");}
        else {
            if (event.getMaterial() == Material.COMPASS) {
                p.setCompassTarget(hunted.getLocation());
                p.sendMessage(hunted.getName() + "'s Richtung wird angezeigt");
                hunted = null;

            }
        }
    }

    @EventHandler
    public void onPlayerRevive(PlayerRespawnEvent respawnEvent){
        respawnEvent.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
    }
}
