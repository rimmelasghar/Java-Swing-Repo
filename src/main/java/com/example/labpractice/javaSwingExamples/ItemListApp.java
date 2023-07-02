package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemListApp extends JFrame implements ActionListener {

    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private JButton addButton;

    private JButton removeButton;
    private JTextField inputField;

    public ItemListApp() {
        // Set up the JFrame
        setTitle("Item List with DB Connectivity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Create the list model and list
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setPreferredSize(new Dimension(200, 150));
        add(new JScrollPane(itemList));

        try{
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                listModel.addElement(name);
            };
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        // Create the input field
        inputField = new JTextField(15);
        add(inputField);

        // Create the add button
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        add(addButton);

        // Create the remove button
        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        add(removeButton);

        // Show the GUI
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String newItem = inputField.getText();
            if (!newItem.isEmpty()) {

                try {
                    // Establish the database connection
                    Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement();

                    // Write the INSERT query
                    String insertQuery = String.format("INSERT INTO items (name) VALUES ('%s')",newItem);
                    // Execute the query
                    int rowsAffected = statement.executeUpdate(insertQuery);

                    System.out.println(rowsAffected + " row(s) inserted successfully.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                listModel.addElement(newItem);
                inputField.setText("");
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = itemList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedName = listModel.getElementAt(selectedIndex);
                try{
                    Connection connection = DatabaseConnection.getConnection();
                    Statement statement =  connection.createStatement();

                    // Write the DELETE query
                    String deleteQuery = String.format("DELETE FROM items WHERE name = '%s'",selectedName);


                    // Execute the query
                    int rowsAffected = statement.executeUpdate(deleteQuery);

                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                listModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ItemListApp());
    }
}
