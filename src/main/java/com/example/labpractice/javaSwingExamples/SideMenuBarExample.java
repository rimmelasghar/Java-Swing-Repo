package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideMenuBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Side Menu Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the side menu panel
        JPanel sideMenuPanel = new JPanel();
        sideMenuPanel.setBackground(Color.DARK_GRAY);
        sideMenuPanel.setPreferredSize(new Dimension(200, frame.getHeight()));
        sideMenuPanel.setLayout(new GridLayout(5, 1));

        // Create the menu buttons
        JButton homeButton = createMenuButton("Home");
        JButton profileButton = createMenuButton("Profile");
        JButton messagesButton = createMenuButton("Messages");
        JButton settingsButton = createMenuButton("Settings");
        JButton logoutButton = createMenuButton("Logout");

        // Add the menu buttons to the side menu panel
        sideMenuPanel.add(homeButton);
        sideMenuPanel.add(profileButton);
        sideMenuPanel.add(messagesButton);
        sideMenuPanel.add(settingsButton);
        sideMenuPanel.add(logoutButton);

        // Add the side menu panel to the main panel
        mainPanel.add(sideMenuPanel, BorderLayout.WEST);

        // Add the main panel to the frame
        frame.getContentPane().add(mainPanel);

        // Display the frame
        frame.setVisible(true);
    }

    // Helper method to create a menu button
    private static JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions when the menu button is clicked
                System.out.println("Clicked: " + text);
            }
        });
        return button;
    }
}
