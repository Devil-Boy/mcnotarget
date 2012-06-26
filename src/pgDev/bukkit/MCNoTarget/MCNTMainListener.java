package pgDev.bukkit.MCNoTarget;

import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

public class MCNTMainListener implements Listener {
	final MCNoTarget plugin;
	
	public MCNTMainListener(final MCNoTarget plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onTarget(EntityTargetEvent event) {
		if (!event.isCancelled()) {
			if (event.getTarget() instanceof Player) {
				Player player = (Player) event.getTarget();
				if (plugin.hasPermissions(player, "mcnotarget." + event.getEntityType().getName().toLowerCase())) {
					if (event.getReason() == TargetReason.CLOSEST_PLAYER || event.getReason() == TargetReason.RANDOM_TARGET) {
						event.setCancelled(true);
					}
				}
			}
		}
	}
}
