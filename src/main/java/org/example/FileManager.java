package org.example;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    //TODO - write in code that creates a folder if a data folder doesnt exist in the sre

    File directory = new File(".");

    String PATH= directory.getAbsolutePath() + "/src/data/";

    public void saveChamps(ArrayList<Champion> champions, String dataName){

        PATH = PATH + dataName + ".bin";

        try{

            File saveFile = new File(PATH);
            FileOutputStream outStream = new FileOutputStream(saveFile);
            ObjectOutputStream objStream = new ObjectOutputStream(outStream);

            for(Champion champ : champions) {
                objStream.writeObject(champ);
            }

            objStream.flush();
            objStream.close();


        }catch ( Exception ex){
            ex.printStackTrace();
        }


    }
}
