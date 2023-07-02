package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditorApp extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public TextEditorApp() {
        setTitle("Text Editor- Created by Rimmel Asghar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create a side menu bar
        JPanel sideMenuPanel = new JPanel();
        sideMenuPanel.setLayout(new BoxLayout(sideMenuPanel, BoxLayout.Y_AXIS));

        // Create buttons
        JButton newButton = new JButton("New");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");

        // Add button actions
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Clear the text area
            }
        });

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(TextEditorApp.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        File selectedFile = fileChooser.getSelectedFile();
                        BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                        String line;
                        StringBuilder content = new StringBuilder();
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }
                        reader.close();
                        textArea.setText(content.toString()); // Set text area content
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(TextEditorApp.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        File selectedFile = fileChooser.getSelectedFile();
                        BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                        writer.write(textArea.getText()); // Write text area content to file
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Add buttons to the side menu panel
        sideMenuPanel.add(newButton);
        sideMenuPanel.add(openButton);
        sideMenuPanel.add(saveButton);
        sideMenuPanel.add(exitButton);

        // Create a text area
        textArea = new JTextArea();

        // Add components to the frame
        getContentPane().add(sideMenuPanel, BorderLayout.WEST);
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextEditorApp app = new TextEditorApp();
                app.setVisible(true);
            }
        });
    }
}
