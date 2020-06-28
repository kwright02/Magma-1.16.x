package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.monster.piglin.PiglinEntity;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Piglin;

public class CraftPiglin extends CraftMonster implements Piglin {

    public CraftPiglin(CraftServer server, PiglinEntity entity) {
        super(server, entity);
    }

    @Override
    public boolean isBaby() {
        return getHandle().isChild();
    }

    @Override
    public void setBaby(boolean flag) {
        getHandle().setChild(flag);
    }

    @Override
    public PiglinEntity getHandle() {
        return (PiglinEntity) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.PIGLIN;
    }

    @Override
    public String toString() {
        return "CraftPiglin";
    }
}