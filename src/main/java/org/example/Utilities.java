package org.example;


public  class Utilities {

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

}