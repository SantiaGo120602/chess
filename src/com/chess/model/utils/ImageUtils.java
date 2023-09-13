package com.chess.model.utils;

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

}
