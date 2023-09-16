package com.chess.view;

import javax.swing.*;

import com.chess.model.utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SquareButton extends JButton {

    private Color backgroundColor = null;
    private BufferedImage overlayImage = null;
    private static BufferedImage targetImage;

    static{
        try {
            targetImage = ImageUtils.resizeImage(ImageIO.read(new File("src/resources/images/icons/icons8-target-100.png")),
                             80,
                            80);
        } catch (IOException e) {

        }
    }

    public SquareButton(Color backgroundColor, String imagePath, Boolean target) {
        this.backgroundColor = backgroundColor;
        try {
            this.overlayImage = ImageIO.read(new File(imagePath));
            this.overlayImage = ImageUtils.resizeImage(overlayImage, 80, 140);
            if (target){
                this.overlayImage = ImageUtils.combineImages(overlayImage, targetImage);
            }
        } catch (IOException e1) {
            if (target){
                this.overlayImage = targetImage;
            }
        }
    }

    public void updateButton(Color backgroundColor, String imagePath, Boolean target) {
        this.backgroundColor = backgroundColor;
        try {
            this.overlayImage = ImageIO.read(new File(imagePath));
            this.overlayImage = ImageUtils.resizeImage(overlayImage, 80, 140);
            if (target){
                this.overlayImage = ImageUtils.combineImages(overlayImage, targetImage);
            }
        } catch (IOException e1) {
            if (target){
                this.overlayImage = targetImage;
            }
        }
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