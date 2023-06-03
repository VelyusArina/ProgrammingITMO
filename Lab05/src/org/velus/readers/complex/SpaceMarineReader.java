package org.velus.readers.complex;

import org.velus.IOManager;
import org.velus.model.*;
import org.velus.readers.simple.StringReader;
import org.velus.readers.simple.enumerable.AstartesCategoryReader;
import org.velus.readers.simple.enumerable.MeleeWeaponReader;
import org.velus.readers.simple.enumerable.WeaponReader;
import org.velus.readers.simple.number.DoubleReader;

import java.time.ZonedDateTime;

public class SpaceMarineReader extends ValueComplexReader<SpaceMarine> {

    public SpaceMarineReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    protected SpaceMarine readFields() {
        long id = System.currentTimeMillis() % Long.MAX_VALUE;
        String name = new StringReader(ioManager).setCanBeEmpty(false).setNullable(false).read("имя");
        Coordinates coordinates = new CoordinatesReader(ioManager).setNullable(false).read("координаты");
        ZonedDateTime creationDate = ZonedDateTime.now();
        double health = new DoubleReader(ioManager).setLowerBound(0.0).setNullable(false).read("здоровье");
        AstartesCategory category = new AstartesCategoryReader(ioManager).setNullable(true).read("категорию");
        Weapon weapon = new WeaponReader(ioManager).setNullable(true).read("оружие дальнего боя");
        MeleeWeapon meleeWeapon = new MeleeWeaponReader(ioManager).setNullable(true).read("оружие ближнего боя");
        Chapter chapter = new ChapterReader(ioManager).setNullable(false).read("главу");
        return new SpaceMarine(id, name, coordinates, creationDate, health, category, weapon, meleeWeapon, chapter);
    }

    @Override
    protected String getTypeName() {
        return SpaceMarine.class.getSimpleName();
    }
}
