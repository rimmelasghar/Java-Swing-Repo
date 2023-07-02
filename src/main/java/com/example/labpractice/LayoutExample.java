package com.example.labpractice;

import javax.swing.*;
import java.awt.*;

public class LayoutExample {
    public static void main(String[] args) {
        // BorderLayout Example
        JFrame frame1 = new JFrame("BorderLayout Example");
        frame1.setLayout(new BorderLayout());
        frame1.add(new JButton("North"), BorderLayout.NORTH);
        frame1.add(new JButton("South"), BorderLayout.SOUTH);
        frame1.add(new JButton("East"), BorderLayout.EAST);
        frame1.add(new JButton("West"), BorderLayout.WEST);
        frame1.add(new JButton("Center"), BorderLayout.CENTER);
        frame1.setSize(400, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        // FlowLayout Example
        JFrame frame2 = new JFrame("FlowLayout Example");
        frame2.setLayout(new FlowLayout());
        frame2.add(new JButton("Button 1"));
        frame2.add(new JButton("Button 2"));
        frame2.add(new JButton("Button 3"));
        frame2.setSize(400, 300);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

        // GridLayout Example
        JFrame frame3 = new JFrame("GridLayout Example");
        frame3.setLayout(new GridLayout(2, 3));
        frame3.add(new JButton("Button 1"));
        frame3.add(new JButton("Button 2"));
        frame3.add(new JButton("Button 3"));
        frame3.add(new JButton("Button 4"));
        frame3.add(new JButton("Button 5"));
        frame3.add(new JButton("Button 6"));
        frame3.setSize(400, 300);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);

        // GridBagLayout Example
        JFrame frame4 = new JFrame("GridBagLayout Example");
        frame4.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        frame4.add(new JButton("Button 1"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        frame4.add(new JButton("Button 2"), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        frame4.add(new JButton("Button 3"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        frame4.add(new JButton("Button 4"), constraints);

        frame4.setSize(400, 300);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);

        // BoxLayout Example
        JFrame frame5 = new JFrame("BoxLayout Example");
        frame5.setLayout(new BoxLayout(frame5.getContentPane(), BoxLayout.Y_AXIS));
        frame5.add(new JButton("Button 1"));
        frame5.add(new JButton("Button 2"));
        frame5.add(new JButton("Button 3"));
        frame5.setSize(400, 300);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setVisible(true);

        // CardLayout Example
        JFrame frame6 = new JFrame("CardLayout Example");
        frame6.setLayout(new CardLayout());
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new FlowLayout());
        cardPanel.add(new JButton("Card 1"));
        cardPanel.add(new JButton("Card 2"));
        cardPanel.add(new JButton("Card 3"));
        frame6.add(cardPanel, "cardPanel");
        CardLayout cardLayout = (CardLayout) frame6.getContentPane().getLayout();
        cardLayout.show(frame6.getContentPane(), "cardPanel");
        frame6.setSize(400, 300);
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.setVisible(true);
    }
}
