package maxmeitner.jqmsg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0 && args[0].equals("reload")) {
            if (sender.hasPermission("jqmsg.reload")) {
                JQMsg.getPlugin().reloadConfig();
                sender.sendMessage(StringHandler.getBetterString("messages.pluginReloaded"));
            } else {sender.sendMessage(StringHandler.getBetterString("messages.noPerms"));}
        }
        return true;
    }
}
