package me.zach.challage.events;

import me.zach.challage.info.Methods;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Ping implements Listener{

	@EventHandler
	public void setPing(ServerListPingEvent e){
		Methods m = new Methods();
		if(m.isStart()==true){
			e.setMotd(m.getMOTD());
			e.setMaxPlayers(0);
		}if(m.isStart()==false){
			e.setMotd(Bukkit.getServer().getMotd());
			e.setMaxPlayers(Bukkit.getMaxPlayers());
		}
	}
	
	
}
