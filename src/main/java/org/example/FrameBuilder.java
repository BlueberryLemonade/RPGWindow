package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBuilder {

    public void addAButton(String text, Container container){
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(button.getText() + " button clicked");
                ClickHandler click = new ClickHandler();
                click.selection(button.getText());
            }
        });

        container.add(button);
    }
}
