package com.chess.model.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;


public final class ImageUtils {
    
    private ImageUtils() {
        throw new AssertionError("This class should not be instantiated.");
    }
    
    public static String getImageFolder(String relativePath) {
        Path fullPath = Paths.get(System.getProperty("user.dir"), relativePath);
        return fullPath.toAbsolutePath().toString();
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
        int maxHeight = Math.max(image1.getHeight(), image2.getHeight());

        BufferedImage combinedImage = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = combinedImage.createGraphics();

        int x = (maxWidth - image2.getWidth()) / 2;
        int y = (maxHeight - image2.getHeight()) / 2;

        g2d.drawImage(image1, 0, 0, null);

        g2d.drawImage(image2, x, y, null);

        g2d.dispose();

        return combinedImage;
    }
}
