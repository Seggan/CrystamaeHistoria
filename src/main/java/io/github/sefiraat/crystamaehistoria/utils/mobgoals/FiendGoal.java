package io.github.sefiraat.crystamaehistoria.utils.mobgoals;

import org.bukkit.entity.Blaze;

import java.util.UUID;

public class FiendGoal extends AbstractGoal<Blaze> {

    public FiendGoal(UUID owningPlayer) {
        super(owningPlayer);
    }

    @Override
    public boolean getFollowsPlayer() {
        return false;
    }
}
