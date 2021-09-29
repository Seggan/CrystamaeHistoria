package io.github.sefiraat.crystamaehistoria.magic.spells;

import io.github.sefiraat.crystamaehistoria.magic.SpellDefinition;
import io.github.sefiraat.crystamaehistoria.magic.spells.interfaces.CastableProjectile;
import io.github.sefiraat.crystamaehistoria.utils.EntityUtils;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class Tempest implements CastableProjectile {

    private static final int DAMAGE = 3;
    private static final int COOLDOWN = 200;
    private static final double KNOCK_BACK_FORCE = 2;
    private static final double AOE_RANGE = 2;
    private static final double PROJECTILE_NUMBER = 10;
    private static final int RADIUS = 10;

    @Override
    public void cast(@NonNull SpellDefinition spellDefinition) {

        spellDefinition.setCastInformation(DAMAGE, AOE_RANGE, KNOCK_BACK_FORCE, COOLDOWN);

        Location location = spellDefinition.getCaster().getLocation();

        for (int i = 0; i < (PROJECTILE_NUMBER * spellDefinition.getPowerMulti()); i++) {
            int xOffset = ThreadLocalRandom.current().nextInt(-RADIUS, RADIUS + 1);
            int zOffset = ThreadLocalRandom.current().nextInt(-RADIUS, RADIUS + 1);
            int x = (int) location.getX() + xOffset;
            int z = (int) location.getZ() + zOffset;
            Location spawnLocation = new Location(
                    location.getWorld(),
                    location.getX() + xOffset,
                    location.getWorld().getHighestBlockYAt(x, z),
                    location.getZ() + zOffset
            );

            LightningStrike lightningStrike = spawnLocation.getWorld().strikeLightning(spawnLocation);
            registerProjectile(lightningStrike, spellDefinition);
        }

    }

    @Override
    public void beforeAffect(@NonNull @NotNull SpellDefinition spellDefinition) {
        for (LivingEntity livingEntity : spellDefinition.getAllTargets()) {
            livingEntity.setFireTicks(40);
        }
    }

    @Override
    public void affect(@NonNull SpellDefinition spellDefinition) {
        for (LivingEntity livingEntity : spellDefinition.getAllTargets()) {
            EntityUtils.damageEntity(livingEntity, spellDefinition.getCaster(), spellDefinition.getDamage(), spellDefinition.getDamageLocation(), spellDefinition.getKnockbackForce());
        }
    }

}