package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {

    private JTextField displayField;

    private String currentNumber;
    private String previousNumber;
    private String operation;

    public CalculatorApp() {
        // Set up the JFrame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Create the display field
        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.PLAIN, 20));
        add(displayField, BorderLayout.NORTH);

        // Create the button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        // Create number buttons
        for (int i = 0; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Create arithmetic operation buttons
        String[] operations = {"+", "-", "*", "/"};
        for (String op : operations) {
            JButton button = new JButton(op);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Create clear and equals buttons
        JButton clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Initialize variables
        currentNumber = "";
        previousNumber = "";
        operation = "";

        // Show the calculator
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (isNumeric(command)) {
            currentNumber += command;
            displayField.setText(currentNumber);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            previousNumber = currentNumber;
            currentNumber = "";
            operation = command;
        } else if (command.equals("C")) {
            currentNumber = "";
            previousNumber = "";
            operation = "";
            displayField.setText("");
        } else if (command.equals("=")) {
            double result = calculateResult();
            displayField.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
            previousNumber = "";
            operation = "";
        }
    }

    private double calculateResult() {
        double num1 = Double.parseDouble(previousNumber);
        double num2 = Double.parseDouble(currentNumber);
        double result = 0.0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        return result;
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorApp());
    }
}
