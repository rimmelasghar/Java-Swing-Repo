package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchApplication extends JFrame {
    private JLabel timeLabel;
    private JButton startButton;
    private JButton pauseButton;
    private JButton resetButton;

    private Timer timer;
    private int elapsedTime;
    private boolean isRunning;

    public StopwatchApplication() {
        setTitle("Stopwatch Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create a time label
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create start button
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        // Create pause button
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });

        // Create reset button
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);

        // Add components to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(timeLabel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void start() {
        if (!isRunning) {
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    elapsedTime++;
                    updateTimeLabel();
                }
            });
            timer.start();
            isRunning = true;
        }
    }

    private void pause() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
        }
    }

    private void reset() {
        timer.stop();
        elapsedTime = 0;
        updateTimeLabel();
        isRunning = false;
    }

    private void updateTimeLabel() {
        int hours = elapsedTime / 3600;
        int minutes = (elapsedTime % 3600) / 60;
        int seconds = elapsedTime % 60;
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StopwatchApplication app = new StopwatchApplication();
                app.setVisible(true);
            }
        });
    }
}
