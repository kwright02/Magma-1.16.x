package org.bukkit.craftbukkit.util;

import net.minecraft.util.DamageSource;

// Util class to create custom DamageSources.
public final class CraftDamageSource extends DamageSource {
    public static DamageSource copyOf(final DamageSource original) {
        CraftDamageSource newSource = new CraftDamageSource(original.msgId);

        // Check ignoresArmor
        if (original.isBypassArmor()) {
            newSource.bypassArmor();
        }

        // Check magic
        if (original.isBypassMagic()) {
            newSource.bypassMagic();
        }

        // Check fire
        if (original.isExplosion()) {
            newSource.setIsFire();
        }

        return newSource;
    }

    private CraftDamageSource(String identifier) {
        super(identifier);
    }
}
