package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ChampCreate extends JFrame implements ActionListener {

    private String name;
    private int strength;

    private Label nameLabel;
    private Label strengthLabel;
    private TextField nameField;
    private TextField strengthField;

    private Button accept;
    private Button cancel;

    public ChampCreate(){

        //Creating the GUI
        super("Champion Creation");
        setSize(400,500);
        setLayout(new FlowLayout());

        //Instantiating GUI elements
        nameLabel = new Label("Name: ");
        strengthLabel = new Label("Strength: ");
        nameField = new TextField(14);
        strengthField = new TextField(2);
        accept = new Button("Accept");
        cancel = new Button("Cancel");
        accept.addActionListener(this);
        cancel.addActionListener(this);

        //Adding elements to GUI
        add(nameLabel);
        add(nameField);
        add(strengthLabel);
        add(strengthField);
        add(accept);
        add(cancel);

        //Final GUI settings
        setLocation(400, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

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


    public void actionPerformed(ActionEvent action){

        if(action.getSource() == accept){
            //TODO - return a champion with the given fields
            if(isNumberic(strengthField.getText())) {
                System.out.println("Accepted");
                dispose();
            }

        }
        if(action.getSource() == cancel){
            System.out.println("Cancelled");
            dispose();
        }
    }
}
