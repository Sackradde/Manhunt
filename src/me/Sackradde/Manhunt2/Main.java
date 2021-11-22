package me.Sackradde.Manhunt2;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    public Player hunted;

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new ClickListener(), this);
    }

    @Override
    public void onDisable(){

    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {
        if (args.length == 0){

        if (label.equalsIgnoreCase("manhuntstart")){
            if (hunted == null){
                sender.sendMessage("You must set a hunted!");
                return true;
            }
            for (Player p: getServer().getOnlinePlayers()
                 ) {

                p.sendMessage("Manhunt Match started!");
                if(p != hunted){
                    p.getInventory().addItem(new ItemStack(Material.COMPASS));
                }

            }
            return true;

        }

        if (command.getName().equalsIgnoreCase("manhunthunted")){
            if (!(sender instanceof Player))
            {
                sender.sendMessage("You must be a player to execute that command!");
                return true;
            }
            if (hunted==null){

            }else{
                hunted.sendMessage(hunted.getName() + " you are no Longer the hunted!");
                hunted.setPlayerListHeader("");
            }
            hunted = (Player) sender;
            hunted.setPlayerListHeader("Hunted");
            sender.sendMessage( hunted.getName() + " you are the hunted!");

            return true;
        }

        }
        return false;
    }
}
