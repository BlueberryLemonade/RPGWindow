package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ChampGUI {

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
            ChampionController cont = new ChampionController();
            cont.createChampion(nameField.getText(), strengthField.getText());
        });

        //Save Button for saving all the created champions to the system
        save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Adding the buttons to the panel
        panel.add(accept);
        panel.add(save);

        //Checks for file
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



}
