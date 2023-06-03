package org.velus.readers.simple.enumerable;

import org.velus.IOManager;
import org.velus.model.Weapon;

public class WeaponReader extends EnumReader<Weapon> {
    public WeaponReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    Weapon[] getEnumValues() {
        return Weapon.values();
    }

    @Override
    Weapon valueOf(String name) {
        return Weapon.valueOf(name);
    }
}
