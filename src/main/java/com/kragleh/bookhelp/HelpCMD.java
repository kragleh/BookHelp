package com.kragleh.bookhelp;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName() != "help") return false;
        if (!(sender instanceof Player)) {
            sender.sendMessage("HelpBook only works for players!");
            return false;
        }

        Player p = (Player) sender;
        ItemStack book = new ItemStack(Material.BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();
        List<String> content = new ArrayList<>();

        content.add("Page 1");
        content.add("Page 2");
        content.add("Page 3");
        content.add("Page 4");

        meta.setTitle("Help");
        meta.setAuthor("Server");
        meta.setPages(content);

        book.setItemMeta(meta);
        p.openBook(book);
        return false;
    }

}
