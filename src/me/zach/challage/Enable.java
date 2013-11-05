package me.zach.challage;

import java.util.logging.Logger;

import me.zach.challage.events.Button;
import me.zach.challage.events.Ping;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Enable extends JavaPlugin{
	public Logger logger = Logger.getLogger("Minecraft");
	@Override
	public void onEnable() {
		enableEvents();
		enableCommands();
		logger.info("My challenge is enabled");
		logger.info("Made by: Zach Farley");
		logger.info("Enjoy! As requested by:");
		logger.info("https://docs.google.com/document/d/1TtY5IXyYzyWjarSCUFTH4hH3U4wrg_0nfv6CetnKs6A/edit");
	}

	@Override
	public void onDisable() {
		logger.info("Challenge disabled!");
		logger.info("Made by: Zach Farley");
	}
	
	private void enableEvents() {
		Bukkit.getPluginManager().registerEvents(new Button(), this);
		Bukkit.getPluginManager().registerEvents(new Ping(), this);
	}
	
	private void enableCommands() {
		this.getCommand("startch").setExecutor(new Start());
	}

	
}
