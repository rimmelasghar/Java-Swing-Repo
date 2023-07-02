package com.example.labpractice.javaSwingExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageViewer extends JFrame {
    private JLabel imageLabel;
    private File[] imageFiles;
    private int currentImageIndex;
    private double zoomFactor;

    public ImageViewer() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton zoomInButton = new JButton("Zoom In");
        JButton zoomOutButton = new JButton("Zoom Out");
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");

        zoomInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zoomFactor += 0.1;
                displayImage();
            }
        });

        zoomOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomFactor > 0.1) {
                    zoomFactor -= 0.1;
                    displayImage();
                }
            }
        });

        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentImageIndex > 0) {
                    currentImageIndex--;
                    displayImage();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentImageIndex < imageFiles.length - 1) {
                    currentImageIndex++;
                    displayImage();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(zoomInButton);
        buttonPanel.add(zoomOutButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void loadImages(String folderPath) {
        File folder = new File(folderPath);
        imageFiles = folder.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".jpg") ||
                        name.toLowerCase().endsWith(".jpeg") ||
                        name.toLowerCase().endsWith(".png") ||
                        name.toLowerCase().endsWith(".gif")
        );
        currentImageIndex = 0;
        zoomFactor = 1.0;
        displayImage();
    }

    private void displayImage() {
        if (imageFiles.length > 0) {
            try {
                BufferedImage image = ImageIO.read(imageFiles[currentImageIndex]);
                int newWidth = (int) (image.getWidth() * zoomFactor);
                int newHeight = (int) (image.getHeight() * zoomFactor);
                Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            imageLabel.setIcon(null);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImageViewer viewer = new ImageViewer();
                viewer.loadImages("G:\\SCD-Exam-Practice\\Lab-Practice\\src\\main\\resources\\images");
                viewer.setVisible(true);
            }
        });
    }
}
