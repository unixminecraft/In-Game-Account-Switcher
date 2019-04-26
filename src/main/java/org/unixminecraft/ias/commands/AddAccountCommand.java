package org.unixminecraft.ias.commands;

import com.github.mrebhan.ingameaccountswitcher.tools.alt.AltDatabase;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import the_fireplace.ias.account.ExtendedAccountData;

public class AddAccountCommand extends CommandBase {

    @Override
    public String getName() {
        return "addaccount";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "§cSyntax: /addaccount <email/username> <password>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(args.length != 2) {
            sender.sendMessage(new TextComponentString(getUsage(sender)));
            return;
        }
        AltDatabase.getInstance().getAlts().add(new ExtendedAccountData(args[0], args[1], args[0]));
        
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
