package io.github.sefiraat.crystamaehistoria.magic.spells.tier1;

import io.github.sefiraat.crystamaehistoria.magic.CastInformation;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.MagicProjectile;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.Spell;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.SpellCoreBuilder;
import io.github.sefiraat.crystamaehistoria.slimefun.machines.liquefactionbasin.SpellRecipe;
import io.github.sefiraat.crystamaehistoria.stories.definition.StoryType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class AirNova extends Spell {

    public AirNova() {
        SpellCoreBuilder spellCoreBuilder = new SpellCoreBuilder(20, true, 10, false, 10, false)
            .makeDamagingSpell(1, true, 1, false)
            .makeProjectileSpell(this::fireProjectiles, 2, false, 2, true)
            .makeProjectileVsEntitySpell(this::projectileHit);
        setSpellCore(spellCoreBuilder.build());
    }

    @ParametersAreNonnullByDefault
    public void fireProjectiles(CastInformation castInformation) {
        double sizeEnd = getRange(castInformation);
        int sizeCast = 2;
        int stepSize = 3;
        Location middle = castInformation.getCastLocation().clone().add(0, 1.5, 0);
        for (double i = 0; i < 360; i += stepSize) {
            double angle = (i * Math.PI / 180);
            int sx = (int) (sizeCast * Math.cos(angle));
            int sz = (int) (sizeCast * Math.sin(angle));
            int dx = (int) (sizeEnd * Math.cos(angle));
            int dz = (int) (sizeEnd * Math.sin(angle));
            Location spawn = middle.clone().add(sx, 0, sz);
            Location destination = middle.clone().add(dx, 0, dz);
            MagicProjectile magicProjectile = new MagicProjectile(EntityType.SHULKER_BULLET, spawn, castInformation.getCaster());
            magicProjectile.setVelocity(destination, 1);

            registerProjectile(magicProjectile, castInformation);
        }

    }

    @ParametersAreNonnullByDefault
    public void projectileHit(CastInformation castInformation) {
        for (LivingEntity livingEntity : getTargets(castInformation, getProjectileAoe(castInformation), true)) {
            damageEntity(
                livingEntity,
                castInformation.getCaster(),
                getDamage(castInformation),
                castInformation.getProjectileLocation().clone().subtract(0, 1,0),
                getKnockback(castInformation)
            );
            displayParticleEffect(livingEntity, Particle.SWEEP_ATTACK, 1, 5);
        }
    }

    @Nonnull
    @Override
    public String getId() {
        return "AIR_NOVA";
    }

    @Nonnull
    @Override
    public String[] getLore() {
        return new String[]{
            "Summons a massive nova of air",
            "around you to knockback foes."
        };
    }

    @Nonnull
    @Override
    public Material getMaterial() {
        return Material.FEATHER;
    }

    @NotNull
    @Override
    public SpellRecipe getRecipe() {
        return new SpellRecipe(
            1,
            StoryType.ELEMENTAL,
            StoryType.MECHANICAL,
            StoryType.ANIMAL
        );
    }
}