package org.example;

import java.io.Serializable;

public class Champion implements Serializable {

    private String name;
    private int strength;

    public Champion(String name, int strength){
        this.name = name;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setName(String name) {
        this.name = name;
    }
}
