package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.item.HangingEntity;
import net.minecraft.util.Direction;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.block.CraftBlock;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Hanging;

public class CraftHanging extends CraftEntity implements Hanging {
    public CraftHanging(CraftServer server, HangingEntity entity) {
        super(server, entity);
    }

    @Override
    public BlockFace getAttachedFace() {
        return getFacing().getOppositeFace();
    }

    @Override
    public void setFacingDirection(BlockFace face) {
        setFacingDirection(face, false);
    }

    @Override
    public boolean setFacingDirection(BlockFace face, boolean force) {
        HangingEntity hanging = getHandle();
        Direction dir = hanging.getDirection();
        switch (face) {
            case SOUTH:
            default:
                getHandle().setDirection(Direction.SOUTH);
                break;
            case WEST:
                getHandle().setDirection(Direction.WEST);
                break;
            case NORTH:
                getHandle().setDirection(Direction.NORTH);
                break;
            case EAST:
                getHandle().setDirection(Direction.EAST);
                break;
        }
        if (!force && !hanging.survives()) {
            // Revert since it doesn't fit
            hanging.setDirection(dir);
            return false;
        }
        return true;
    }

    @Override
    public BlockFace getFacing() {
        Direction direction = this.getHandle().getDirection();
        if (direction == null) return BlockFace.SELF;
        return CraftBlock.notchToBlockFace(direction);
    }

    @Override
    public HangingEntity getHandle() {
        return (HangingEntity) entity;
    }

    @Override
    public String toString() {
        return "CraftHanging";
    }

    @Override
    public EntityType getType() {
        return EntityType.UNKNOWN;
    }
}
