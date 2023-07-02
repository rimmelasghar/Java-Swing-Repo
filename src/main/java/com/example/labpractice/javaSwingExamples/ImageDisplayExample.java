package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageDisplayExample {
    public static void main(String[] args) {
        // Create a JFrame to hold the image
        JFrame frame = new JFrame("Image Display Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create a JPanel to hold the JButton
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a JButton
        JButton button = new JButton("Press me for a Surprise");

        // Add ActionListener to the JButton
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and configure the JDialog
                JDialog dialog = new JDialog(frame, "UIT Picture", true);
                dialog.setSize(400, 400);
                dialog.setLocationRelativeTo(frame);

                // Create a JPanel to hold the JLabel with the image
                JPanel dialogPanel = new JPanel();
                dialogPanel.setLayout(new BorderLayout());

                // Create a JLabel to display the image
                JLabel label = new JLabel();

                // Load the image from a file
                ImageIcon imageIcon = new ImageIcon("G:\\SCD-Exam-Practice\\Lab-Practice\\src\\main\\resources\\images\\uitu.jpg");

                // Set the image to the JLabel
                label.setIcon(imageIcon);

                // Add the JLabel to the dialog panel
                dialogPanel.add(label, BorderLayout.CENTER);

                // Add the dialog panel to the dialog's content pane
                dialog.getContentPane().add(dialogPanel);

                // Display the dialog
                dialog.setVisible(true);
            }
        });

        // Add the JButton to the JPanel
        panel.add(button);

        // Add the JPanel to the JFrame
        frame.getContentPane().add(panel);

        // Display the frame
        frame.setVisible(true);
    }
}
