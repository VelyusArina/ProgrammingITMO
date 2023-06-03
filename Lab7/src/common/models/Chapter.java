package common.models;

import java.io.Serializable;

public class Chapter implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;


    public Chapter(){}

    public Chapter (String name, String parentLegion){
        this.name = name;
        this.parentLegion = parentLegion;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getParentLegion() {
        return parentLegion;
    }
    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }

}
