package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPG extends JFrame implements ActionListener {

   

    public static void main(String[] args) {
        RPG game = new RPG();

    }

    public RPG(){
        //Create and add the GUI pieces
        super("RPG Window");
        setLayout(new FlowLayout());
        final Label entryGameText = new Label("Welcome to the RPG Window");

        final Button play = new Button("Play Game");
        final Button quit = new Button("Quit");
        final Button tools = new Button("Dev Tools");

        add(entryGameText);
        add(play);
        add(quit);
        add(tools);


        setSize(770,500);
        setLocation(300,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent action){

    }
}