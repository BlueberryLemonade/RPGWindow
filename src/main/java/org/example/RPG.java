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

    }

    public RPG(){

        boxArea = new JFrame("RPG Window");

        //Create and add the GUI pieces


        boxArea.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();

        entryGameText = new Label("Welcome to the RPG Window");

        play = new JButton("Play");
        quit = new JButton("Quit");
        tools = new JButton("Dev Tools");

        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Play Clicked");
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Quit Clicked");
            }
        });

        tools.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Dev Tools Clicked");
            }
        });


        panel.add(entryGameText);



        buttonPanel.add(play);
        buttonPanel.add(quit);
        buttonPanel.add(tools);



        boxArea.add(panel);
        boxArea.add(buttonPanel);

        boxArea.setSize(770,500);
        boxArea.setLocation(300,500);
        boxArea.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        boxArea.setVisible(true);


    }
}