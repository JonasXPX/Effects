package me.jonasxpx.baudeefeitos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Teste extends JavaPlugin implements Listener{
	
	BukkitTask task;
	Random r = new Random();
	HashMap<Player, Boolean> pl = new HashMap<Player, Boolean>();
   @Override
	public void onEnable() {
	   getServer().getPluginManager().registerEvents(this, this);
	   new Efeitos(this);
	
   }
   
   @Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
	   Player p = (Player)sender;
	   if(args.length == 0){
		   if(!p.hasPermission("vip.efeito")){
			   p.sendMessage("§cApenas VIP HERO ter permissão para usar este comando");
			   return true;
		   }
		 p.openInventory(criaoBau(p));
	   }
	   return true;
   }
   
   @EventHandler
   public void close(InventoryCloseEvent e){
	   if(e.getInventory().getName().equals("efeito")){
		   task.cancel();
	   }
   }
   @EventHandler
	public void clickEfeito(InventoryClickEvent e){
		if(e.getInventory().getTitle().equals("efeitos")){
			if(e.getCurrentItem() == null){
				return;
			}
			Player p = (Player)e.getWhoClicked();
			if(e.getCurrentItem().getType() == Material.LAVA){
				Efeitos.lava(p);
				e.setCancelled(true);
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.STICK){
				Efeitos.cancelar(p);
				e.setCancelled(true);
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.LAVA_BUCKET){
				Efeitos.drip_lava(p);
				e.setCancelled(true);
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.NOTE_BLOCK){
				Efeitos.note(p);
				e.setCancelled(true);
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE){
				Efeitos.enchant(p);
				e.setCancelled(true);
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.WOOL){
				Efeitos.redstone(p);
				e.setCancelled(true);
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.RED_ROSE){
				Efeitos.heart(p);
				e.setCancelled(true);
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){
				Efeitos.teste(p);
				e.setCancelled(true);
				e.getView().close();
			}
			e.setCancelled(true);
			e.getView().close();
		}
	}
   @EventHandler
   public void desligar(PlayerQuitEvent e){
	  Efeitos.cancelar(e.getPlayer());
   }
   
   
   String[] s = {"§2Este plugin ainda está sendo escrito", "§2Qualquer bug deve ser reportado para JonasXPX"};
   public Inventory criaoBau(Player player){
	   ItemStack vidro = criarItem(Material.THIN_GLASS, "§7Efeito para adicionar", "JonasXPX");
	   ItemStack cancelar = new ItemStack(Material.STICK); ItemMeta mt = cancelar.getItemMeta(); mt.setDisplayName("§cDesligar Efeito"); cancelar.setItemMeta(mt);
	   ItemStack lava = criarItem(Material.LAVA, "§cLava", "§2Gotas de lava");
	   ItemStack explosao = criarItem(Material.LAVA_BUCKET, "§2Gotas de lava", "§cEfeito da lava atravesando o bloco");
	   ItemStack note = criarItem(Material.NOTE_BLOCK, "§2Notas musicais", "§cCria varias notas musicas");
	   ItemStack mobspawner = criarItem(Material.ENCHANTMENT_TABLE, "§2Letras da Matrix", "§cParticulas soltada pela mesa de encantamento");
	   ItemStack livro = criarItem(Material.BOOK, "§c§lEM DESENVOLVIMENTO", s);
	   ItemStack fire = criarItem(Material.FIREWORK, ".", ".");
	   livro.addUnsafeEnchantment(Enchantment.OXYGEN, 5);
	   ItemStack s = criarItem(Material.RED_ROSE, "§2Particulas de coração" , "§cO amor esta no ar ;)" );
	   Inventory a = getServer().createInventory(player, 54, "efeitos");
	   disco(a, "§2Particulas de cores", "§cDisco de cores");
	   a.setItem(53, cancelar);
	   a.setItem(0, lava);
	   a.setItem(1, explosao);
	   a.setItem(2, note);
	   a.setItem(3, mobspawner);
	   a.setItem(5, s);
	   a.setItem(6, fire);
	   for(int x = 7; x < a.getSize(); x++){
		   if(a.getItem(x)==null)a.setItem(x, vidro);
	   }
	   a.setItem(22, livro);
	   return a;
   }
   
   ItemStack item = null;
   ItemMeta mt = null;
   public void disco(final Inventory inv, final String nome, final String ... descriçao){
	   task = new BukkitRunnable() {
		@Override
		public void run() {
			int data = r.nextInt(15);
			item = new ItemStack(Material.WOOL, 0, Short.parseShort(Integer.toString(data)));
			mt = item.getItemMeta();
			mt.setDisplayName(nome);
			List<String> desc = new ArrayList<String>();
			for(String st : descriçao){
				desc.add(st);
			}
			mt.setLore(desc);
			item.setItemMeta(mt);
			inv.setItem(4, item);
		}
	}.runTaskTimer(this, 0, 5);
   }
   
   
   public ItemStack criarItem(Material item1, String nome, String ... descriçao){
	   ItemStack item = new ItemStack(item1);
	   List<String> desc = new ArrayList<>();
	   ItemMeta mt = item.getItemMeta();
	   mt.setDisplayName(nome);
	   for(String st : descriçao){
		   desc.add(st);
	   }
	   mt.setLore(desc);
	   item.setItemMeta(mt);
	   return item;
   }
   
   public void teste(PlayerMoveEvent e){
	   Efeitos.teste(e.getPlayer());
   }
}
