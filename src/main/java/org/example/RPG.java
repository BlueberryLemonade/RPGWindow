package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RPG {
    private JFrame boxArea;
    private Label entryGameText;
    private JButton play;
    private JButton quit;
    private JButton tools;

    public static void main(String[] args) {
        RPG game = new RPG();
        game.start();
    }



    public void start(){
        createGUI();
    }

    public void createGUI(){
        //Create and add the GUI pieces
        boxArea = new JFrame("RPG Window");
        boxArea.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel buttonPanel = new JPanel();
        entryGameText = new Label("Welcome to the RPG Window");

        //Creating the Buttons

        panel.add(entryGameText);

        //Adding anonymous functions to listen for events on buttons
        play = new JButton("Play");
        play.addActionListener(action -> {
            ChampCreate creator = new ChampCreate();
            creator.createGUI();
        });
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Adding the components to the frame itself

        panel.add(play);
        boxArea.add(panel);
        boxArea.add(buttonPanel);

        //Setting default settings for GUI
        boxArea.setSize(370,500);
        boxArea.setLocation(750,300);
        boxArea.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        boxArea.setVisible(true);
    }
}