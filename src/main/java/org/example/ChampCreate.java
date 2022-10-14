package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ChampCreate{

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
    private ArrayList<Champion> championList;
    private JList<String> champJList;



    public void createGUI(){
        JFrame frame = new JFrame("Champion Creator");
        JPanel panel = new JPanel();


        //Creating the GUI
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

        //Adding all the elements to the pannel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(strengthLabel);
        panel.add(strengthField);

        //Creating Buttons and Listeners to go with them
        accept = new JButton("Accept");
        accept.addActionListener(e -> {
            if(validityTest()){
                System.out.println("Valid");

                Champion createdChamp = createChampion();
                listModel.addElement(createdChamp.getName());
                championList.add(createdChamp);
            }
        });

        save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileManager filer = new FileManager();
                filer.saveChamps(championList, "champions");
            }
        });

        panel.add(accept);
        panel.add(save);

        //If there is a champion list, fill the JList with the names of the champions
        if(championList != null && championList.size() > 0) {

            String[] listOfChampions = new String[championList.size()];


            for(int i=0; i<championList.size(); i++){
                Champion champ = championList.get(i);
                listOfChampions[i] = champ.getName();
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

    public Champion createChampion(){

        int strength;
        String name = nameField.getText();
        if(Utilities.isInteger(strengthField.getText())){
            strength = Integer.parseInt(strengthField.getText());
        } else {
            strength = 1;
        }
        Champion createdChamp = new Champion(name,strength);


        return createdChamp;
    }

    private boolean validityTest(){
        if(Utilities.isInteger(strengthField.getText()) && Utilities.isValidStringWithSpaces(nameField.getText())){
            return true;
        } else {
            return false;
        }
    }

    private void updateList(){
        System.out.println(championList.size());
        for(int i=0; i<championList.size(); i++){

        }
    }


}
