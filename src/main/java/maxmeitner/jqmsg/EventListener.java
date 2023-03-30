package maxmeitner.jqmsg;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        FileConfiguration conf = JQMsg.getPlugin().getConfig();
        if (player.hasPlayedBefore()) {
            if (conf.getBoolean("messages.onJoin")) {
                e.setJoinMessage(StringHandler.getBetterString("messages.joinMsg").replace("%player%", player.getName()));
            }
            if (conf.getBoolean("messages.personalMsgOnJoin")) {
                player.sendMessage(StringHandler.getBetterString("messages.personalJoinMsg").replace("%player%", player.getName()));
            }

        } else {
            if (conf.getBoolean("messages.onFirstJoin")) {
                e.setJoinMessage(StringHandler.getBetterString("messages.firstJoinMsg").replace("%player%", player.getName()));
            }
            if (conf.getBoolean("messages.personalMsgOnFirstJoin")) {
                player.sendMessage(StringHandler.getBetterString("messages.personalFirstJoinMsg").replace("%player%", player.getName()));
            }
        }
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent e) {
        String playerName = e.getPlayer().getName();
        FileConfiguration conf = JQMsg.getPlugin().getConfig();
        if (conf.getBoolean("messages.onQuit")) {
            e.setQuitMessage(StringHandler.getBetterString("messages.quitMsg").replace("%player%", playerName));
        }
    }
}
