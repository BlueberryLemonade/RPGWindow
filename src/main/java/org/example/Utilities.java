package org.example;

public  class Utilities {

    public static boolean isInteger(String str){

        try{
            int number = Integer.parseInt(str);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }

    }
}
