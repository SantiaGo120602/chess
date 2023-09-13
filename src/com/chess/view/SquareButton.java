package com.chess.view;

import javax.swing.*;

import com.chess.model.utils.ImageUtils;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SquareButton extends JButton {
    private static String imagesPath = ImageUtils.getImageFolder("resources/images");

    private Color backgroundColor = null;
    private BufferedImage overlayImage = null;

    public SquareButton(Color backgroundColor, String imagePath) {
        this.backgroundColor = backgroundColor;
        try {
            this.overlayImage = ImageIO.read(new File(imagesPath + imagePath));
        } catch (IOException e) {
            e.printStackTrace();
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
}