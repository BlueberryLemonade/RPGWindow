package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class ChampCreate implements Savable{

    private String name;
    private int strength;

    private Label nameLabel;
    private Label strengthLabel;
    private TextField nameField;
    private TextField strengthField;

    private JButton accept;
    private JButton cancel;
    private JButton save;

    private DefaultListModel<String> listModel;
    private ArrayList<Externalizable> championList;
    private ArrayList<Externalizable> champDatabase;
    private ArrayList<Champion> availableChampion;
    private JList<String> champJList;

    /*-----------------------------Overrides---------------------------------*/
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


    /*--------------------------------------GUI------------------------------*/
    //Constructor
    public void createGUI(){
        //Holders
        JFrame frame = new JFrame("Champion Creator");
        JPanel panel = new JPanel();


        //Settings
        panel.setSize(400,500);
        panel.setLayout(new FlowLayout());

        //Instantiating GUI elements
        nameLabel = new Label("Name: ");
        strengthLabel = new Label("Strength: ");
        nameField = new TextField(14);
        strengthField = new TextField(2);
        nameField.setMaximumSize(new Dimension(100,300));
        championList = new ArrayList<>();
        listModel = new DefaultListModel<>();

        //Adding all the elements to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(strengthLabel);
        panel.add(strengthField);

        //Creating Buttons and Listeners to go with them
        //Accept Button for when you are ready to put the input through
        accept = new JButton("Accept");
        accept.addActionListener(e -> {
            if(validityTest()){
                System.out.println("Valid");

                Champion createdChamp = createChampion();
                listModel.addElement(createdChamp.getName());
                championList.add(createdChamp);
            }
        });

        //Save Button for saving all the created champions to the system
        save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                saveFile(championList, "champs");
            }
        });

        //Adding the buttons to the panel
        panel.add(accept);
        panel.add(save);

        //Checks for file
        System.out.println(fileExists("champs"));
        //If there is a champion list, fill the JList with the names of the champions
        if(championList != null && championList.size() > 0) {

            String[] listOfChampions = new String[championList.size()];

            for(int i = 0; i<championList.size(); i++){
            }

        }

        champJList = new JList<>(listModel);
        panel.add(champJList);
        frame.add(panel);
        //Final GUI settings
        frame.setLocation(800, 300);
        frame.setSize(400, 650);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    //Champion Generation
    public Champion createChampion(){

        int strength;
        String name = nameField.getText();
        if(isInteger(strengthField.getText())){
            strength = Integer.parseInt(strengthField.getText());
        } else {
            strength = 1;
        }
        Champion createdChamp = new Champion(name,strength);


        return createdChamp;
    }

    private boolean validityTest(){
        if(isInteger(strengthField.getText()) && isValidStringWithSpaces(nameField.getText())){
            return true;
        } else {
            return false;
        }
    }

    //TODO - turn readChamps into a database loader
    private void readChamps(){
        fileExists("champs");
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
