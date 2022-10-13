package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Loader {

    public boolean usernameLoad(){
        String PATH = ".";

        try{
            FileInputStream fileIn = new FileInputStream(PATH);
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            return false;
        }
    return true;
    }
}
