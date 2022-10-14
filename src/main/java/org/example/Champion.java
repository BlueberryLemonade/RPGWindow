package org.example;

import java.io.*;

public class Champion implements Externalizable {

    private String name;
    private int strength;

    public Champion(String name, int strength){
        this.name = name;
        this.strength = strength;
    }

    @Override
    public void writeExternal(ObjectOutput objOut) throws IOException {
        objOut.writeUTF(name);
        objOut.writeInt(strength);
    }

    @Override
    public void readExternal(ObjectInput in) throws  IOException{
        this.name = in.readUTF();
        this.strength = in.readInt();
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
