/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.block.impl;

import net.minecraft.block.CommandBlockBlock;

public final class CraftCommand extends org.bukkit.craftbukkit.block.data.CraftBlockData implements org.bukkit.block.data.type.CommandBlock, org.bukkit.block.data.Directional {

    public CraftCommand() {
        super();
    }

    public CraftCommand(net.minecraft.block.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.block.data.type.CraftCommandBlock

    private static final net.minecraft.state.BooleanProperty CONDITIONAL = getBoolean(CommandBlockBlock.class, "conditional");

    @Override
    public boolean isConditional() {
        return get(CONDITIONAL);
    }

    @Override
    public void setConditional(boolean conditional) {
        set(CONDITIONAL, conditional);
    }

    // org.bukkit.craftbukkit.block.data.CraftDirectional

    private static final net.minecraft.state.EnumProperty<?> FACING = getEnum(CommandBlockBlock.class, "facing");

    @Override
    public org.bukkit.block.BlockFace getFacing() {
        return get(FACING, org.bukkit.block.BlockFace.class);
    }

    @Override
    public void setFacing(org.bukkit.block.BlockFace facing) {
        set(FACING, facing);
    }

    @Override
    public java.util.Set<org.bukkit.block.BlockFace> getFaces() {
        return getValues(FACING, org.bukkit.block.BlockFace.class);
    }
}