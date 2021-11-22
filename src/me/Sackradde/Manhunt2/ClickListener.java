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


public class ClickListener implements Listener {


    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();
        Player hunted = null;

        for (Player player:Bukkit.getServer().getOnlinePlayers()
             ) {
            if (player.getPlayerListHeader().equalsIgnoreCase("Hunted")){
                hunted = player;
            }
        }

        if (hunted == null){}
        else {
            if (event.getMaterial() == Material.COMPASS) {
                p.setCompassTarget(hunted.getLocation());
                p.sendMessage(hunted.getName() + "'s Richtung wird angezeigt");

            }
        }
    }

    @EventHandler
    public void onPlayerRevive(PlayerRespawnEvent respawnEvent){
        respawnEvent.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
    }
}
