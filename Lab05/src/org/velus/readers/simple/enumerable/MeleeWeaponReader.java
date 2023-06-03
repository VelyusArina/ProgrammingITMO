package org.velus.readers.simple.enumerable;

import org.velus.IOManager;
import org.velus.model.MeleeWeapon;

public class MeleeWeaponReader extends EnumReader<MeleeWeapon> {
    public MeleeWeaponReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    MeleeWeapon[] getEnumValues() {
        return MeleeWeapon.values();
    }

    @Override
    MeleeWeapon valueOf(String name) {
        return MeleeWeapon.valueOf(name);
    }
}