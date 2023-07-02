package com.example.labpractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Frame Hello World");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Jframe example");
        AtomicBoolean b = new AtomicBoolean(true);
        JButton btn = new JButton();
        btn.setText("Button");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello, Swing!");
                if(b.get()) {
                    b.set(false);
                    label.setVisible(false);
                } else {
                    b.set(true);
                    label.setVisible(true);
                }
            }
        };

        btn.addActionListener(actionListener);

        panel.add(label);
        panel.add(btn);
        frame.add(panel);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
