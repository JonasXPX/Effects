package me.jonasxpx.baudeefeitos;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import com.darkblade12.particleeffect.ParticleEffect;

public class Efeitos {

	private static HashMap<Player, BukkitTask> ativos = new HashMap<Player, BukkitTask>();
	
	private static final long TIME = 5;
	private static Teste pl;
	private static int raio = 0;
	private static Random random = new Random();
	
	public Efeitos(Teste plugin){
		pl = plugin;
	}
	
	public static void barrier(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.BARRIER.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, 1);
		ativos.put(p, task);
	}
	
	private static double x = 0.0;
	
	public static void teste(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				if(x <= 0.5){
					Vector dir = p.getLocation().getDirection().normalize();
					ParticleEffect.TOWN_AURA.display((float) dir.getX(), (float) dir.getY(), (float)dir.getZ(), 10, 10, p.getLocation().add(0, 0.8, 0), 50D);
					ParticleEffect.REDSTONE.display((float)x,(float)x,(float)x, 0.1F, 1, p.getLocation().add(0, 2, 0), 50D);
					x = x + 0.01;
				} else
					x = 0;
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
		
	}
	public static void block_crack(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.BLOCK_CRACK.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void block_dust(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.BLOCK_DUST.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void cloud(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.CLOUD.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void crit(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.CRIT.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void crit_magic(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.CRIT_MAGIC.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void drip_lava(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.DRIP_LAVA.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void drip_water(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.DRIP_WATER.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void enchant(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.ENCHANTMENT_TABLE.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void explosion_huge(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.EXPLOSION_HUGE.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void explosion_large(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.EXPLOSION_LARGE.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void explosion_normal(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.EXPLOSION_NORMAL.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void fireworks(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.FIREWORKS_SPARK.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void flame(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.FLAME.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void footstep(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.FOOTSTEP.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void heart(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.HEART.display(0.5F, 1.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void item_crack(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.ITEM_CRACK.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void item_take(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.ITEM_TAKE.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void lava(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				raio += random.nextInt(20);
				if(raio >= 360) raio = 0;
				double radian = Math.toRadians(raio);
				double cos = Math.cos(radian);
				double sin = Math.sin(radian);
				ParticleEffect.DRIP_LAVA.display(0,0,0, 0.4F, 20, p.getLocation().add((float)cos, (float)cos + 1, (float)sin), 25);
				ParticleEffect.DRIP_LAVA.display(0,0,0, 0.4F, 20, p.getLocation().add((float)cos * -1, (float)cos + 1, (float)sin * -1), 25);
			}
		}.runTaskTimer(pl, 0, 0L);
		ativos.put(p, task);
	}
	public static void mob_appearance(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.MOB_APPEARANCE.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void note(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.NOTE.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void portal(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			@Override
			public void run() {
				ParticleEffect.PORTAL.display(0.5F, 0.5F, 0.5F, 2F, 20, p.getLocation(), 20D);
			}
		}.runTaskTimer(pl, 0, TIME);
		ativos.put(p, task);
	}
	public static void redstone(final Player p){
		cancelar(p);
		BukkitTask task = null;
		task = new BukkitRunnable() {
			private int radio;

			@Override
			public void run() {
				if(radio >= 360) radio = 0;
				double radians = Math.toRadians(radio);
				final double cos = Math.cos(radians) * 0.3;
				final double sin = Math.sin(radians) * 0.3;
				final Location loc = p.getLocation();
				radio = radio + 25;
				new BukkitRunnable() {
					@Override
					public void run() {
						ParticleEffect.REDSTONE.display(0.01F, 0, 0.01F, 1F, 25, loc.add(sin, 2, cos), 25);
						ParticleEffect.REDSTONE.display(0.01F, 0, 0.01F, 1F, 25, loc.add(sin, -2, cos), 25);
					}
				}.runTask(Teste.instance);
			}
		}.runTaskTimerAsynchronously(Teste.instance, 0L, 0L);
		ativos.put(p, task);
	}
	public static void cancelar(Player p){
		try{
		ativos.get(p).cancel();
		}catch(NullPointerException e){
			ativos.put(p, null);
		}
	}
}
