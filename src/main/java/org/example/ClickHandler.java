package org.example;

public class ClickHandler {

    public void selection(String input){
        System.out.println("The input was: " + input);
        String selection = input.toUpperCase();
        switch(selection){
            case "PLAY" -> {
                ChampCreate create = new ChampCreate();

            }
        }

    }
}
