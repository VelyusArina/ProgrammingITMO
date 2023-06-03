package org.velus.model;

import java.io.Serializable;

public class Chapter implements Serializable {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final String parentLegion;


    public Chapter(String name, String parentLegion) {
        this.name = name;
        this.parentLegion = parentLegion;
    }

    public String getName() {
        return name;
    }

    public String getParentLegion() {
        return parentLegion;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "name='" + name + '\'' +
                ", parentLegion='" + parentLegion + '\'' +
                '}';
    }
}
