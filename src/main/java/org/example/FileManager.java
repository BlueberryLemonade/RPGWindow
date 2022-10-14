package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

public class FileManager implements Serializable {


    public void writeString(){
        //TODO - write in code that creates a folder if a data folder doesnt exist in the sre
        File directory = new File(".");

        String PATH= directory.getAbsolutePath() + "/src/data/stringdata.txt";
        String file = "Write this";

        try{
            FileWriter writer = new FileWriter(PATH);

            writer.write(file);

            writer.flush();
            writer.close();

        }catch ( Exception ex){
            ex.printStackTrace();
        }


    }
}
