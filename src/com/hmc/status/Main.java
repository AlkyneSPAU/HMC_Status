package com.hmc.status;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
	
		System.out.println("测试启动成功");
		
	}
	@Override
	public void onDisable() {
		System.out.println("测试卸载成功！");
	}
	
	
	
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {

		return true;
	}
}
