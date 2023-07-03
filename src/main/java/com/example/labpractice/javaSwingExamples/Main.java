package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {

        // Create the frame
        JFrame frame = new JFrame("Swing Frame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create the left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1));

        // Create the buttons
        JButton newButton = new JButton("New");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        JButton saveAsButton = new JButton("Save As");
        JButton viewButton = new JButton("View");

        // Add action listener to the "Name" button
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textField = new JTextField(20);
                textField.setName("MainTextBox");
                JPanel rightPanel = (JPanel) frame.getContentPane().getComponent(1);
                rightPanel.removeAll();
                rightPanel.add(textField);
                frame.revalidate();
                frame.repaint();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel rightPanel = (JPanel) frame.getContentPane().getComponent(1);
                JTextField textField = (JTextField) rightPanel.getComponent(0);
                String text = textField.getText();

                // Insert the data into the database
                try {
                    //write name of your schema instead of msk
                    String url = "jdbc:mysql://localhost:3306/msk";
                    String username = "root";
                    String password = "12345678";
                    Connection connection = DriverManager.getConnection(url, username, password);
                    //write name of your table instead of lab

                    String insertSql = "INSERT INTO lab (Name) VALUES (?)";

                    PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
                    preparedStatement.setString(1, text);
                    preparedStatement.executeUpdate();
                    connection.close();
                    System.out.println("Data inserted into the database.");
                } catch (SQLException ex) {
                    System.out.println("Database connection failed. Error message: " + ex.getMessage());
                }
            }
        });

        saveAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text field
                JPanel rightPanel = (JPanel) frame.getContentPane().getComponent(1);
                JTextField textField = (JTextField) rightPanel.getComponent(0);
                String text = textField.getText();

                // Create a file chooser dialog
                JFileChooser fileChooser = new JFileChooser();

                // Show the dialog and get the selected file
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    String filePath = file.getAbsolutePath();

                    // Write the text to the selected file
                    try (PrintWriter writer = new PrintWriter(filePath)) {
                        writer.write(text);
                        writer.flush();
                        System.out.println("Text saved to file: " + filePath);
                    } catch (IOException ex) {
                        System.out.println("Failed to save file. Error message: " + ex.getMessage());
                    }
                }
            }
        });

        // Add the buttons to the left panel
        leftPanel.add(newButton);
        leftPanel.add(openButton);
        leftPanel.add(saveButton);
        leftPanel.add(saveAsButton);
        leftPanel.add(viewButton);

        // Create the right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        // Add the panels to the frame
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(leftPanel, BorderLayout.WEST);
        frame.getContentPane().add(rightPanel, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }
}