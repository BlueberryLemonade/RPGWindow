package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public  class Utilities {

    static File directory = new File(".");
    static String DATAPATH= directory.getAbsolutePath() + "/src/data/";

    public static boolean isInteger(String str) {

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Not a valid integer");
            return false;
        }

    }

    public static boolean isValidStringWithSpaces(String str) {


        //First checks for beginning or ending spaces

        if (Character.isWhitespace(str.charAt(0))|| Character.isWhitespace(str.charAt(str.length() -1))) {

            System.out.println("You can't have trailing or leading spaces");

            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)) && !Character.isSpaceChar(str.charAt(i)))  {
                System.out.println("You have to have only letters or space in string");
                return false;
            }
        }

        return true;
    }


    public static void saveData(Collection<Externalizable> saveObjects, String dataName){


        DATAPATH = DATAPATH + dataName + ".magic";

        try{

            File saveFile = new File(DATAPATH);
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

    public static void fileExists(String path){

        try{
            FileInputStream fileInput = new FileInputStream(path);
        } catch(FileNotFoundException fnfe){
            System.out.println("File didn't exist, creating");
            DATAPATH = DATAPATH + path + ".magic";

            File emptyFile = new File(DATAPATH);
            try {
                emptyFile.createNewFile();
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

}