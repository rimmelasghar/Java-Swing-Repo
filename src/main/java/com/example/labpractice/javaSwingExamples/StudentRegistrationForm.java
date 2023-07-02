package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StudentRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JPanel imgPanel = new JPanel();
        JLabel headingLabel = new JLabel("Welcome to UIT Registration Form");
        Font heading = new Font(Font.SANS_SERIF,Font.BOLD,30);
        headingLabel.setFont(heading);
        headingLabel.setVisible(true);

        imgPanel.setLayout(new FlowLayout());
        imgPanel.add(headingLabel);
        imgPanel.setVisible(true);

        // btn Panel

        JPanel btnPanel = new JPanel();
        JButton btn = new JButton("Submit");
        btn.setBounds(50,50,50,50);

        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(btn);
        btnPanel.setVisible(true);


        // top panel

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setVisible(true);

        JLabel username = new JLabel("Enter Student Name");
        username.setVisible(true);

        JTextField usernameEnter = new JTextField();
        usernameEnter.setPreferredSize(new Dimension(200, usernameEnter.getPreferredSize().height));
        usernameEnter.setVisible(true);

        JCheckBox feesStatus = new JCheckBox("Fees Payed");
        feesStatus.setVisible(true);

        topPanel.add(username);
        topPanel.add(usernameEnter);
        topPanel.add(feesStatus);
        topPanel.setVisible(true);

        // main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.add(topPanel);
        mainPanel.add(btnPanel);
        mainPanel.setVisible(true);


        // List panel
        JPanel listPanel = new JPanel();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> itemList = new JList<>(listModel);
        itemList.setPreferredSize(new Dimension(200, 150));
        listPanel.add(new JScrollPane(itemList));
        listPanel.setVisible(true);


        frame.add(imgPanel,BorderLayout.NORTH);
        frame.add(mainPanel,BorderLayout.CENTER);
        frame.add(listPanel,BorderLayout.SOUTH);
        frame.setSize(600,300);
        frame.setResizable(false);
        frame.setVisible(true);

        ActionListener submitActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = usernameEnter.getText();
                if(!Objects.equals(studentName, "")) {
                    listModel.addElement(studentName);
                    usernameEnter.setText("");
                } else {
                    System.out.println("Enter correct name");
                }
            }
        };

        btn.addActionListener(submitActionListener);
    }
}

