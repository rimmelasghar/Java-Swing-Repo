package com.example.labpractice.javaSwingExamples;

import com.example.labpractice.javaSwingExamples.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Username");
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 20)); // Set preferred size for JTextField

        JLabel label2 = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 20)); // Set preferred size for JPasswordField

        JButton loginbtn = new JButton("Login");
        loginbtn.setBounds(50,50,50,50);

        JDialog d = new JDialog(frame,"Login Successfull",true);
        d.setLayout(new FlowLayout());
        d.setSize(300,300);
        JLabel labelDialog1 = new JLabel("Login Succesfull");
        labelDialog1.setVisible(true);
        d.add(labelDialog1);

        JDialog d2 = new JDialog(frame,"Login UnSuccessfull",true);
        d2.setLayout(new FlowLayout());
        d2.setSize(300,300);
        JLabel labelDialog2 = new JLabel("Login UnSuccesfull");
        labelDialog2.setVisible(true);
        d2.add(labelDialog2);

        // Action
        ActionListener loginBtnActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                char[] password = passwordField.getPassword();
                Boolean login = false;
                String passwordString = new String(password);
                System.out.println("Entered username: " + username);
                System.out.println("Entered password: " + passwordString);
                try {
                    Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM usertable");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("username");
                        String userpass = resultSet.getString("password");
                        if(name.equals(username) && userpass.equals(passwordString)){
                            login = true;
                            break;
                        }
                    };
                    if(login){
                        d.setVisible(true);
                        System.out.println("Login Successful");
                    }else {
                        d2.setVisible(true);
                        System.out.println("Login UnSuccessful");
                    };
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                ex.printStackTrace();
            }
                }
        };

        loginbtn.addActionListener(loginBtnActionListener);
        panel.add(label);
        panel.add(textField);
        panel.add(label2);
        panel.add(passwordField);
        panel.add(loginbtn);
        panel.setSize(200,200);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.add(panel);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
