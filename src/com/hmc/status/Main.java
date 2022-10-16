package com.hmc.status;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.hmc.status.commands.HMC_Command;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		
		Bukkit.getPluginCommand("hmc").setExecutor(new HMC_Command());
		System.out.println("HMC Status已启动!");
		
	}
	@Override
	public void onDisable() {
		//System.out.println("HMC Status已卸载!");
	}
	
	
	
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {

		return true;
	}
}
