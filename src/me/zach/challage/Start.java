package me.zach.challage;

import me.zach.challage.info.Methods;
import net.minecraft.server.v1_6_R3.Block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start implements CommandExecutor {

	Methods m = new Methods();
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg,
			String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.isOp()==true){
				if(args.length<0){
					m.setStart(true);
					int lx = p.getLocation().getBlockX();
					int ly = p.getLocation().getBlockY();
					int lz = p.getLocation().getBlockZ();
					World w = p.getWorld();
					Location ll1 = new Location(w, lx+2, ly, lz);
					w.getBlockAt(ll1).setType(Material.WOOL);
					Location ll2 = new Location(w, lx+3, ly, lz);
					w.getBlockAt(ll2).setType(Material.STONE_BUTTON);
					m.setButton("x", lx+3);
					m.setButton("y", ly);
					m.setButton("z", lz);
				}
			}
		}
		return false;
	}

}
