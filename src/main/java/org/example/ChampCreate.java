package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ChampCreate{

    private String name;
    private int strength;

    private Label nameLabel;
    private Label strengthLabel;
    private TextField nameField;
    private TextField strengthField;


    private Button cancel;

    public ChampCreate(){

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

        cancel = new Button("Cancel");

        panel.add(nameField);
        panel.add(strengthLabel);
        panel.add(strengthField);
        FrameBuilder builder = new FrameBuilder();
        builder.addAButton("Accept", panel);

        panel.add(cancel);

        frame.add(panel);
        //Final GUI settings
        frame.setLocation(800, 300);
        frame.setSize(400, 650);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    private boolean isNumberic(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException nfe){
            System.out.println("Must have a number in the strength field");
            return false;
        }
    }


}
