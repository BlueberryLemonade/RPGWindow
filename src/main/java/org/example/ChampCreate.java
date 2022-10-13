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

    public ChampCreate(){
        //Creating the GUI
        super("Champion Creation");
        setSize(400,500);
        setLayout(new FlowLayout());

        nameLabel = new Label("Name: ");
        strengthLabel = new Label("Strength: ");
        nameField = new TextField(14);
        strengthField = new TextField(2);
        accept = new Button("Accept");

        add(nameLabel);
        add(nameField);
        add(strengthLabel);
        add(strengthField);
        add(accept);

        setLocation(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent action){

        if(action.getSource() == accept){
            //TODO - return a champion with the given fields
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        }
    }
}
