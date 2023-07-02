package com.example.labpractice;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonExample {
    public static void main(String[] args) {
        // Create a JFrame to hold the button
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JButton
        JButton button = new JButton("Click Me!");

        // Add the button to the frame
        frame.getContentPane().add(button);

        // Set the size and make the frame visible
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
