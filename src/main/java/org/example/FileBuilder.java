package org.example;

import java.io.*;
import java.util.Collection;

public class FileBuilder {



    static File directory = new File(".");
    final static String DATAPATH= directory.getAbsolutePath() + "/src/data/";

    public  void saveData(Collection<Externalizable> saveObjects, String dataName){

        String newDataPath = DATAPATH + dataName + ".magic";


        try{

            File saveFile = new File(newDataPath);
            FileOutputStream outStream = new FileOutputStream(saveFile);
            ObjectOutputStream objStream = new ObjectOutputStream(outStream);

            for(Externalizable saveObject : saveObjects) {
                objStream.writeObject(saveObject);
            }

            objStream.flush();
            objStream.close();

        }catch ( Exception ex){
            ex.printStackTrace();
        }

    }

    public void fileExists(String path){

        try{
            FileInputStream fileInput = new FileInputStream(path);
        } catch(FileNotFoundException fnfe){
            System.out.println("File didn't exist, creating" +
                    "");


            String newDataPath = DATAPATH + path + ".magic";

            File emptyFile = new File(newDataPath);
            try {
                emptyFile.createNewFile();
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }



}
