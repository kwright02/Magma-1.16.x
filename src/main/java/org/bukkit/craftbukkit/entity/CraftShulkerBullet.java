package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.projectiles.ProjectileSource;

public class CraftShulkerBullet extends AbstractProjectile implements ShulkerBullet {

    public CraftShulkerBullet(CraftServer server, ShulkerBulletEntity entity) {
        super(server, entity);
    }

    @Override
    public ProjectileSource getShooter() {
        return getHandle().projectileSource;
    }

    @Override
    public void setShooter(ProjectileSource shooter) {
        if (shooter instanceof LivingEntity) {
            getHandle().setOwner(((CraftEntity) shooter).getHandle());
        } else {
            getHandle().setOwner(null);
        }
        getHandle().projectileSource = shooter;
    }

    @Override
    public org.bukkit.entity.Entity getTarget() {
        return getHandle().getTarget() != null ? getHandle().getTarget().getBukkitEntity() : null;
    }

    @Override
    public void setTarget(org.bukkit.entity.Entity target) {
        getHandle().setTarget(target == null ? null : ((CraftEntity) target).getHandle());
    }

    @Override
    public String toString() {
        return "CraftShulkerBullet";
    }

    @Override
    public EntityType getType() {
        return EntityType.SHULKER_BULLET;
    }

    @Override
    public ShulkerBulletEntity getHandle() {
        return (ShulkerBulletEntity) entity;
    }
}
