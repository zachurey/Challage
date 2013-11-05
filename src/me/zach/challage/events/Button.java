package me.zach.challage.events;

import me.zach.challage.info.Methods;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Button implements Listener{
	Methods m = new Methods();
	boolean answer;
	
	@EventHandler
	public void hitbutton(PlayerInteractEvent e){
		if(m.isStart()==true){
			Player p = e.getPlayer();
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(e.getClickedBlock().getType() == Material.STONE_BUTTON){
				int lx = e.getClickedBlock().getLocation().getBlockX();
				int ly = e.getClickedBlock().getLocation().getBlockY();
				int lz = e.getClickedBlock().getLocation().getBlockZ();
				if(m.getButton("x")==lx){
					if(m.getButton("y")==ly){
						if(m.getButton("z")==lz){
							answer=true;
							p.sendMessage("Hi " + p.getDisplayName() + "! Do you like pie?");
							p.sendMessage("Type yes or no in the chat!");
						}
					}
				}
				}
			}
		}else{
			
		}
	}
	
	@EventHandler
	public void YesorNo(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(m.isStart()==true){
			if(answer==true){
				if(e.getMessage()=="yes"){
					p.sendMessage("Well good for you! Thanks awsome person!");
				}if(e.getMessage()=="no"){
					p.sendMessage("WHAT???!!! WHY??? YOU'RE GOING TO " + ChatColor.LIGHT_PURPLE + "EXPLOLDE!");
					p.sendMessage(ChatColor.GOLD + "jk");
					answer=false;
				}if(!(e.getMessage()=="yes" || e.getMessage()=="no")){
					answer=false;
					p.sendMessage(ChatColor.RED + "ERROR: Pease say yes or no!");
				}
			}
		}
	}
	
	
	
}
