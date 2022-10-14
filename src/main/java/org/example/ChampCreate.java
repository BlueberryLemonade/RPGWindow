package org.example;

import javax.swing.*;
import java.awt.*;

public class ChampCreate{

    private String name;
    private int strength;

    private Label nameLabel;
    private Label strengthLabel;
    private TextField nameField;
    private TextField strengthField;

    private JButton accept;
    private JButton cancel;

    private DefaultListModel<String> championList;
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
        championList = new DefaultListModel<>();

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(strengthLabel);
        panel.add(strengthField);

        accept = new JButton("Accept");

        accept.addActionListener(e -> {
            if(validityTest()){
                System.out.println("Valid");
                championList.addElement(createChampion().getName());
            }
        });

        panel.add(accept);
        if(championList != null) {
            champJList = new JList<>(championList);
            panel.add(champJList);
        }

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


}
