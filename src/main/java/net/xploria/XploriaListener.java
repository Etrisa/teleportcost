package net.xploria;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Comparator;
import java.util.Optional;

public class XploriaListener implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Ät skit plugin fan");
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
// Teleport player to specific location
//        player.teleport(new Location(player.getWorld(), 500, 64, -200));
        Optional<Entity> creeper = player.getWorld().getEntities().stream()
            .filter(entity -> entity instanceof Creeper)
            .min(Comparator.comparingDouble(creep -> creep.getLocation().distance(player.getLocation())));
        if (creeper.isPresent()) {
            player.teleport(creeper.get());
        }

        return true;
    }

    @EventHandler
    public void event(PlayerJoinEvent event) {

    }

}
