package org.velus.model;

import org.velus.IOManager;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class SpaceMarine implements Comparable<SpaceMarine>, Serializable {
    private static final String SEPARATOR = " ";

    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final double health; //Значение поля должно быть больше 0
    private final AstartesCategory category; //Поле может быть null
    private final Weapon weaponType; //Поле может быть null
    private final MeleeWeapon meleeWeapon; //Поле может быть null
    private final Chapter chapter; //Поле может быть null

    public SpaceMarine(
            long id,
            String name,
            Coordinates coordinates,
            ZonedDateTime creationDate,
            double health,
            AstartesCategory category,
            Weapon weaponType,
            MeleeWeapon meleeWeapon,
            Chapter chapter
    ) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public double getHealth() {
        return health;
    }

    public long getId() {
        return id;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public int compareTo(SpaceMarine o) {
        if (getId() == o.getId()) return 0;
        return getId() < o.getId() ? -1 : 1;
    }

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", category=" + category +
                ", weaponType=" + weaponType +
                ", meleeWeapon=" + meleeWeapon +
                ", chapter=" + chapter +
                '}';
    }

    public void toCSV(IOManager ioManager) {
        writeField(ioManager, id);
        writeField(ioManager, name);
        writeField(ioManager, coordinates.getX());
        writeField(ioManager, coordinates.getY());
        writeField(ioManager, creationDate);
        writeField(ioManager, health);
        writeField(ioManager, category);
        writeField(ioManager, weaponType);
        writeField(ioManager, meleeWeapon);
        writeField(ioManager, chapter.getName());
        writeField(ioManager, chapter.getParentLegion());
        ioManager.writeLine("");
    }

    private void writeField(IOManager ioManager, Object field) {
        if (field == null) {
            ioManager.write(Character.MAX_VALUE + SEPARATOR);
        } else {
            ioManager.write(field + SEPARATOR);
        }
    }

    public static SpaceMarine fromCSV(IOManager ioManager) {
        long id = Long.parseLong(ioManager.readNext());
        String name = ioManager.readNext();
        Double x = Double.parseDouble(ioManager.readNext());
        double y = Double.parseDouble(ioManager.readNext());
        ZonedDateTime creationDate = ZonedDateTime.parse(ioManager.readNext());
        float heath = Float.parseFloat(ioManager.readNext());
        String next = ioManager.readNext();
        AstartesCategory category = null;
        if (!next.equals("" + Character.MAX_VALUE)) category = AstartesCategory.valueOf(next);
        next = ioManager.readNext();
        Weapon weaponType = null;
        if (!next.equals("" + Character.MAX_VALUE)) weaponType = Weapon.valueOf(next);
        next = ioManager.readNext();
        MeleeWeapon meleeWeapon = null;
        if (!next.equals("" + Character.MAX_VALUE)) meleeWeapon = MeleeWeapon.valueOf(next);
        String chapterName = null;
        next = ioManager.readNext();
        if (!next.equals("" + Character.MAX_VALUE)) chapterName = new String(next);
        String chapterLegion = null;
        next = ioManager.readNext();
        if (!next.equals("" + Character.MAX_VALUE)) chapterLegion = new String(next);
        return new SpaceMarine(
                id,
                name,
                new Coordinates(x, y),
                creationDate,
                heath,
                category,
                weaponType,
                meleeWeapon,
                new Chapter(chapterName, chapterLegion)
        );
    }
}

