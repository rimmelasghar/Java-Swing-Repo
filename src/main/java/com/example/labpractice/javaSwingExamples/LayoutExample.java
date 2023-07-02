package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;

public class LayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // BorderLayout Example
        JPanel borderLayoutPanel = new JPanel();
        borderLayoutPanel.setLayout(new BorderLayout());
        borderLayoutPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderLayoutPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderLayoutPanel.add(new JButton("East"), BorderLayout.EAST);
        borderLayoutPanel.add(new JButton("West"), BorderLayout.WEST);
        borderLayoutPanel.add(new JButton("Center"), BorderLayout.CENTER);
        mainPanel.add(borderLayoutPanel);

        // FlowLayout Example
        JPanel flowLayoutPanel = new JPanel();
        flowLayoutPanel.setLayout(new FlowLayout());
        flowLayoutPanel.add(new JButton("Button 1"));
        flowLayoutPanel.add(new JButton("Button 2"));
        flowLayoutPanel.add(new JButton("Button 3"));
        mainPanel.add(flowLayoutPanel);

        // GridLayout Example
        JPanel gridLayoutPanel = new JPanel();
        gridLayoutPanel.setLayout(new GridLayout(2, 3));
        gridLayoutPanel.add(new JButton("Button 1"));
        gridLayoutPanel.add(new JButton("Button 2"));
        gridLayoutPanel.add(new JButton("Button 3"));
        gridLayoutPanel.add(new JButton("Button 4"));
        gridLayoutPanel.add(new JButton("Button 5"));
        gridLayoutPanel.add(new JButton("Button 6"));
        mainPanel.add(gridLayoutPanel);

        // GridBagLayout Example
        JPanel gridBagLayoutPanel = new JPanel();
        gridBagLayoutPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        gridBagLayoutPanel.add(new JButton("Button 1"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        gridBagLayoutPanel.add(new JButton("Button 2"), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        gridBagLayoutPanel.add(new JButton("Button 3"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        gridBagLayoutPanel.add(new JButton("Button 4"), constraints);
        mainPanel.add(gridBagLayoutPanel);

        // BoxLayout Example
        JPanel boxLayoutPanel = new JPanel();
        boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.Y_AXIS));
        boxLayoutPanel.add(new JButton("Button 1"));
        boxLayoutPanel.add(new JButton("Button 2"));
        boxLayoutPanel.add(new JButton("Button 3"));
        mainPanel.add(boxLayoutPanel);

        // CardLayout Example
        JPanel cardLayoutPanel = new JPanel();
        cardLayoutPanel.setLayout(new CardLayout());
        JPanel cardPanel1 = new JPanel();
        cardPanel1.add(new JButton("Card 1"));
        cardLayoutPanel.add(cardPanel1, "card1");
        JPanel cardPanel2 = new JPanel();
        cardPanel2.add(new JButton("Card 2"));
        cardLayoutPanel.add(cardPanel2, "card2");
        JPanel cardPanel3 = new JPanel();
        cardPanel3.add(new JButton("Card 3"));
        cardLayoutPanel.add(cardPanel3, "card3");
        mainPanel.add(cardLayoutPanel);

        frame.add(mainPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
