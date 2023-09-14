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

    public SquareButton(Color backgroundColor, String imagePath) {
        this.backgroundColor = backgroundColor;
        try {
            this.overlayImage = ImageIO.read(new File(imagePath));
            this.overlayImage = resizeImage(overlayImage, 80, 170);
            
            
        } catch (IOException e) {

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
}