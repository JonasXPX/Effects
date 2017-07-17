package me.jonasxpx.baudeefeitos;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.darkblade12.particleeffect.ParticleEffect;

public class CreateEffect {
	
	private Player player;
	private BukkitTask task = null;
	private double radio = 0;
	
	public CreateEffect(Player player) {
		this.player = player;
	}
	
	public void start(final ParticleEffect type){
		task = new BukkitRunnable() {
			@Override
			public void run() {
				if(radio >= 360) radio = 0;
				double radians = Math.toRadians(radio);
				final double cos = Math.cos(radians) * 0.3;
				final double sin = Math.sin(radians) * 0.3;
				final Location loc = player.getLocation();
				radio = radio + 25;
				new BukkitRunnable() {
					@Override
					public void run() {
						type.display(0.01F, 0, 0.01F, 1F, 25, loc.add(sin, 2, cos), 25);
						type.display(0.01F, 0, 0.01F, 1F, 25, loc.add(sin, -2, cos), 25);
					}
				}.runTask(Teste.instance);
			}
		}.runTaskTimerAsynchronously(Teste.instance, 0L, 0L);
	}
	
	
	public void stop(){
		if(task != null) task.cancel();
	}
}
