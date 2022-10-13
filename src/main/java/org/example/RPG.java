package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class RPG extends JFrame implements ActionListener {
    private Label entryGameText;
    private Button play;
    private Button quit;
    private Button tools;

    public static void main(String[] args) {
        RPG game = new RPG();

    }

    public RPG(){
        //Create and add the GUI pieces
        super("RPG Window");

        setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();

        entryGameText = new Label("Welcome to the RPG Window");

        play = new Button("Play Game");
        quit = new Button("Quit");
        tools = new Button("Dev Tools");

        panel.add(entryGameText);

        play.addActionListener(this);
        quit.addActionListener(this);
        tools.addActionListener(this);

        buttonPanel.add(play);
        buttonPanel.add(quit);
        buttonPanel.add(tools);



        add(panel);
        add(buttonPanel);

        setSize(770,500);
        setLocation(300,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent action){

        System.out.println(action.getSource());
        if(action.getSource() == play ){
            //TODO - write play command
            System.out.println("Play Clicked");
            Loader load = new Loader();
            if(!load.usernameLoad()){
                System.out.println("CREATE A NEW CHAMPION");
                ChampCreate creator = new ChampCreate();

            }

        }
        if(action.getSource() == quit){
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        if(action.getSource() == tools){
            //TODO - write dev tools command
        }
    }
}