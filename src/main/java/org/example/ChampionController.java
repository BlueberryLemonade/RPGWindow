package org.example;

import java.io.*;
import java.util.Collection;

public class ChampionController implements Savable {


    public ChampionController(){

    }
    //Champion Generation
    public Champion createChampion(String name, String strength){

        if(validChampion(name, strength)) {
            Champion createdChamp = new Champion(name, Integer.parseInt(strength));
            System.out.println("Champion created");
            return createdChamp;
        } else {
            return null;
        }
    }

    private boolean validChampion(String nameField, String strengthField ){
        return isInteger(strengthField) && isValidStringWithSpaces(nameField);
    }

    //TODO - turn readChamps into a database loader
    private void readChamps(){
        fileExists("champs");
    }

    @Override
    public void saveFile(Collection<Externalizable> saveData, String fileName){


        try{
            String path = pathGenerator(fileName);
            File saveFile = new File(path);
            FileOutputStream outStream = new FileOutputStream(saveFile);
            ObjectOutputStream objStream = new ObjectOutputStream(outStream);

            for(Externalizable saveObject : saveData) {
                objStream.writeObject(saveObject);
            }

            objStream.flush();
            objStream.close();

        }catch ( Exception ex){
            ex.printStackTrace();
        }
    }


    /*----------------------------------------------------LOGIC------------------------------------------*/
    // Logic handlers for the class
    //Verify integers is used for field inputs
    private boolean isInteger(String str) {

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Not a valid integer");
            return false;
        }

    }


    //This is used to make sure the input is only letters or space character with none trailing
    //or leading
    private boolean isValidStringWithSpaces(String str) {

        //First checks for beginning or ending spaces
        if (Character.isWhitespace(str.charAt(0))|| Character.isWhitespace(str.charAt(str.length() -1))) {
            System.out.println("You can't have trailing or leading spaces");
            return false;
        }
        //Then checks to ensure every character is either a letter or a space
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)) && !Character.isSpaceChar(str.charAt(i)))  {
                System.out.println("You have to have only letters or space in string");
                return false;
            }
        }
        return true;
    }

    //Ensuring the file is present and creating on if it is not
    public boolean fileExists(String path){

        String magicPath = pathGenerator(path);

        System.out.println(magicPath);
        try{
            FileInputStream fileInput = new FileInputStream(magicPath);
        } catch(FileNotFoundException fnfe){


            try {
                File emptyFile = new File(magicPath);
                if(emptyFile.createNewFile()){
                    System.out.println("No File was found, created one instead");
                }
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return false;
    }

    private String pathGenerator(String str){
        File directory = new File(".");

        return directory.getAbsolutePath() + "/src/data/" + str + ".magic";
    }


}
