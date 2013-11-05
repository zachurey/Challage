package me.zach.challage.info;

import java.io.File;

import me.zach.challage.Enable;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Methods {
	Enable plugin;
	private Boolean start;
	public void makeConfig(){
		File pFile = new File(this.plugin.getDataFolder(), "config.yml");
        if (!pFile.exists())
          try {
            pFile.createNewFile();
            FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
            pConfig.set("MOTD", "&4Test MOTD!");
            pConfig.set("bx", "0");
            pConfig.set("by", "0");
            pConfig.set("bz", "0");
            pConfig.save(pFile);
          }
          catch (Exception e) {
        	  plugin.logger.severe("ERROR: Making config!");
          }
	}
	
	public String getMOTD(){
		String MOTD = null;
		File pFile = new File(this.plugin.getDataFolder(), "config.yml");
		if(!pFile.exists()){
			makeConfig();
		}if(pFile.exists()){
			FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
			MOTD = ChatColor.translateAlternateColorCodes('&', pConfig.get("MOTD").toString());
		}
		return MOTD;
	}
	
	public void setButton(String num, int cords){
			File pFile = new File(this.plugin.getDataFolder(), "config.yml");
			if(!pFile.exists()){
				makeConfig();
			}if(pFile.exists()){
				FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
				if(num=="x"){
					pConfig.set("bx", cords);
				}
				if(num=="y"){
					pConfig.set("by", cords);
				}
				if(num=="z"){
					pConfig.set("bz", cords);
				}
			}
		}
	
	public int getButton(String i){
		int buttonx = 0;
		File pFile = new File(this.plugin.getDataFolder(), "config.yml");
			if(!pFile.exists()){
				makeConfig();
			}if(pFile.exists()){
				FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
				if(i=="x")
				buttonx = pConfig.getInt("bx");
				else if(i=="y")
				buttonx = pConfig.getInt("by");
				else if(i=="z")
				buttonx = pConfig.getInt("bz");
		}
			return buttonx;
	}

	
	public boolean isStart(){
		return start;
	}
	
	public void setStart(Boolean s){
		if(s==true){
			start=true;
		}
		if(s==false){
			start=false;
		}
	}
	
	
}
