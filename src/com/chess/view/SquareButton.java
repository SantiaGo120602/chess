package com.chess.view;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SquareButton extends JButton {

    private Color backgroundColor = null;
    private BufferedImage overlayImage = null;

    public SquareButton(Color backgroundColor, String imagePath, Boolean target) {
        this.backgroundColor = backgroundColor;
        try {
            this.overlayImage = ImageIO.read(new File(imagePath));
            this.overlayImage = resizeImage(overlayImage, 80, 170);


            if (target){
                this.overlayImage = combineImages(overlayImage,
                ImageIO.read(new File("/home/santiago/Documents/personal_projects/java/chess/src/resources/images/icons/icons8-target-100.png")));
            }

        } catch (IOException e1) {
            try {
                if (target){
                    this.overlayImage = ImageIO.read(new File("/home/santiago/Documents/personal_projects/java/chess/src/resources/images/icons/icons8-target-100.png"));
                }
            } catch (IOException e2) {

            }

        }

        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (overlayImage != null) {
            int x = (getWidth() - overlayImage.getWidth()) / 2;
            int y = (getHeight() - overlayImage.getHeight()) / 2;
            g.drawImage(overlayImage, x, y, null);
        }
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

        Graphics2D g2d = resizedImage.createGraphics();

        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);

        g2d.dispose();

        return resizedImage;
    }

    public static BufferedImage combineImages(BufferedImage image1, BufferedImage image2) {
        int maxWidth = Math.max(image1.getWidth(), image2.getWidth());
        int totalHeight = Math.max(image1.getHeight(), image2.getHeight());

        BufferedImage combinedImage = new BufferedImage(maxWidth, totalHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = combinedImage.createGraphics();

        g2d.drawImage(image1, 0, 0, null);

        g2d.drawImage(image2, 0, 0, null);

        g2d.dispose();

        return combinedImage;
    }
}