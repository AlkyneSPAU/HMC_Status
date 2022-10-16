package com.hmc.status.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class HMC_Command implements CommandExecutor{
	
	public static List<String> getStatus() {
		
		String status1;
		String status2;
		String cpu = Runtime.getRuntime().availableProcessors() + "";
		String maxMem = Runtime.getRuntime().maxMemory() / 1024 / 1024 + "";
		String freeMem = Runtime.getRuntime().freeMemory() / 1024 / 1024 + "";
		String usedMem = (Integer.parseInt(maxMem) - Integer.parseInt(freeMem)) + "";
		String onlines = Bukkit.getServer().getOnlinePlayers().size() + "";
		/*
		List<String> statuses = new ArrayList<>();
		statuses.add(cpu);
		statuses.add(maxMem);
		statuses.add(freeMem);
		statuses.add(onlines);
		*/
		
		
		
		status1 = (ChatColor.GOLD + "\n——————————服务器状态——————————"
				+ ChatColor.YELLOW + "\nCPU数量:" + ChatColor.GREEN + cpu 
				+ ChatColor.YELLOW + "\n已使用内存大小:" + ChatColor.GREEN + usedMem + "MB"
				+ ChatColor.YELLOW + "\n空闲内存:" + ChatColor.GREEN + freeMem + "MB\n\n" 
				+ ChatColor.RED + "——————————————————————" 
				+ ChatColor.YELLOW+"\n\n玩家数量:" + ChatColor.GREEN + onlines);
		
		status2 = ( "\n——————————服务器状态——————————"
					+ "\nCPU数量:"  + cpu 
					+  "\n已使用内存大小:" + usedMem + "MB"
					+ "\n空闲内存:" + freeMem + "MB\n\n" 
					+ "——————————————————————" 
					+ "\n\n玩家数量:" + onlines);
		
		List<String> status = new ArrayList<>();
		status.add(status1);
		status.add(status2);
		return status;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("hmc")) {
			
			if (args.length > 0) {
				
				if (args[0].equalsIgnoreCase("status")) {
					
						List<String> status = getStatus();
						String opStatus = status.get(0);
						String consoleStatus = status.get(1);
						
					if (sender instanceof Player) {
						
						Player player = (Player) sender;
						
						if (player.hasPermission("status.me")) {
							
							player.sendMessage(ChatColor.GOLD + "尊敬的管理员" + player.getName() + ":" + opStatus);
							
						} 
					} else {
						
						System.out.println("尊敬的Console用户" + ":" + consoleStatus);
						
					}
				} 
				return true;
				
			}
		}
		return false;
	}

}
